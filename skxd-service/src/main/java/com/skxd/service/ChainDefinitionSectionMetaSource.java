package com.skxd.service;
/**
 * 借助spring {@link FactoryBean} 对apache shiro的premission进行动态创建 动态的从数据库中读取权限信息
 *
 * @author wangt
 */
import com.skxd.dao.SkxdAdminModuleMapper;
import com.skxd.dao.SkxdAdminRoleModuleMapper;
import com.skxd.model.SkxdAdminModule;
import com.skxd.model.SkxdAdminModuleExample;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ChainDefinitionSectionMetaSource implements FactoryBean<Section> {

    public static int i;

    private String filterChainDefinitions;

    @Autowired
    private SkxdAdminModuleMapper ymsjModuleMapper;

    @Autowired
    private SkxdAdminRoleModuleMapper ymsjRoleModuleMapper;

    /**
     * 通过filterChainDefinitions对默认的链接过滤定义
     *
     * @param filterChainDefinitions 默认的接过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public Section getObject() throws BeansException {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);
        System.out.println(filterChainDefinitions);
        Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        SkxdAdminModuleExample ymsjModuleExample = new SkxdAdminModuleExample();
        ymsjModuleExample.createCriteria().andLevelEqualTo(2);
        List<SkxdAdminModule> ymsjModuleList = ymsjModuleMapper.selectByExample(ymsjModuleExample);
        for (SkxdAdminModule ymsjModule : ymsjModuleList) {
            if (EmptyUtils.isNotEmpty(ymsjModule.getUrl()) && EmptyUtils.isNotEmpty(ymsjModule.getValue())) {
                section.put(ymsjModule.getUrl(), "perms[" + ymsjModule.getValue() + "]");
            }
        }
        section.put("/**", "anon");
        for (String s : section.keySet()) {
            System.out.println(s + "----" + section.get(s) + "-----------section");
        }
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}