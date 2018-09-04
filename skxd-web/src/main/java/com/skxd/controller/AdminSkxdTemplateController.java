package com.skxd.controller;

import com.skxd.model.SkxdAdminDictionaryExample;
import com.skxd.model.SkxdTemplateInput;
import com.skxd.model.SkxdTemplateProject;
import com.skxd.model.SkxdTemplateStep;
import com.skxd.service.ISkxdAdminDictionaryService;
import com.skxd.service.ISkxdAdminInputService;
import com.skxd.service.ISkxdAdminProjectService;
import com.skxd.service.ISkxdAdminStepService;
import com.skxd.vo.DataTableVo;
import com.skxd.vo.InputType;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/template")
public class AdminSkxdTemplateController {

    @Autowired
    private ISkxdAdminProjectService projectService;

    @Autowired
    private ISkxdAdminStepService stepService;

    @Autowired
    private ISkxdAdminInputService inputService;

    @Autowired
    private ISkxdAdminDictionaryService skxdAdminDictionaryService;

    @RequestMapping("/project")
    public String project() {

        return "/template/project";
    }

    @RequestMapping("/projectPage")
    @ResponseBody
    public DataTableVo projectPage(DataTableVo paramDataTableVo) {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdTemplateProject> page = projectService.queryProjectPage(params);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping(value = "/toAddProject")
    public String addProject(Model model, String id) {
        SkxdTemplateProject project;
        if (id == null) {
            project = new SkxdTemplateProject();
        } else {
            project = projectService.findById(id);
        }
        model.addAttribute("project", project);
        return "/template/addProject";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult addProject(Model model, SkxdTemplateProject project) {
        model.addAttribute("project", project);
        ReturnResult result = null;
        int flag = projectService.saveOrUpdate(project);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping("/step")
    public String step(String projectId, Model mode, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        mode.addAttribute("ctx", basePath);
        mode.addAttribute("projectId", projectId);
        return "/template/step";
    }

    @RequestMapping("/stepPage")
    @ResponseBody
    public DataTableVo stepPage(DataTableVo paramDataTableVo, String projectId) {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdTemplateStep> page = stepService.queryPage(params, projectId);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }

    @RequestMapping(value = "/toAddStep")
    public String addStep(String id, String projectId, Model mode) {
        SkxdTemplateStep step;
        if (id == null) {
            step = new SkxdTemplateStep();
            mode.addAttribute("projectId", projectId);
        } else {
            step = stepService.findById(id);
            projectId = step.getProjectId();
            mode.addAttribute("projectId", projectId);
        }
        List<SkxdTemplateStep> stepList = stepService.querySkxdTemplateStepListByProject(projectId);
        mode.addAttribute("step", step);
        mode.addAttribute("stepList", stepList);
        mode.addAttribute("id", id);
        return "/template/addStep";
    }


    @RequestMapping(value = "/addStep")
    @ResponseBody
    public ReturnResult addStep(Model model, SkxdTemplateStep step) {
        ReturnResult result = null;
        int flag = stepService.saveOrUpdate(step);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }


    @RequestMapping(value = "/deleteStep")
    @ResponseBody
    public ReturnResult deleteStep(Model model, String ids) {
        ReturnResult result = null;
        int flag = stepService.delete(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }


    @RequestMapping("/tempInput")
    public String tempInput(String stepId, String projectId, Model mode, HttpServletRequest request) {
        List<SkxdTemplateStep> skxdTemplateStepList=stepService.querySkxdTemplateStepListByProject(projectId);
        mode.addAttribute("stepId", stepId);
        mode.addAttribute("projectId", projectId);
        mode.addAttribute("skxdTemplateStepList", skxdTemplateStepList);
        return "/template/tempInput";
    }

    @RequestMapping("/tempInputPage")
    @ResponseBody
    public DataTableVo tempInputPage(DataTableVo paramDataTableVo, String projectId) {
        DataTableVo dataTableVo = null;
        Map params = DataTableVo.cpoyDataTableToMap(paramDataTableVo);
        Page<SkxdTemplateInput> page = inputService.queryPage(params, projectId);
        dataTableVo = DataTableVo.cpoyPageToDataTable(page);
        dataTableVo.setsEcho(paramDataTableVo.getsEcho());
        return dataTableVo;
    }


    @RequestMapping(value = "/toAddInput")
    public String addInput(String id, String projectId, String stepId, Model mode) throws Exception {
        List<InputType> inputList = Arrays.asList(new InputType[]{new InputType("文本展示", "view")
                , new InputType("标题展示", "title"), new InputType("文本输入", "text"), new InputType("大文本输入", "textarea")
                , new InputType("选项选择", "select"), new InputType("文件上传", "file"), new InputType("地图定位", "position")
                , new InputType("引用字典", "dic"), new InputType("日期输入", "date"), new InputType("扫描输入", "cam")});

        List<InputType> staticTypeList = Arrays.asList(new InputType[]
                {new InputType("凝血标本量及质控开展情况", "1"),
                        new InputType("流变标本量及质控开展情况", "2"),
                        new InputType("预留第三种类型", "3"),
                        new InputType("预留第四种类型", "4")
                });
        SkxdTemplateInput input = null;
        if (id == null) {
            input = new SkxdTemplateInput();
        } else {
            input = inputService.findById(id);
        }
        SkxdTemplateProject project = projectService.findById(projectId);
        SkxdTemplateStep step = stepService.findById(stepId);
        SkxdAdminDictionaryExample skxdAdminDictionaryExample = new SkxdAdminDictionaryExample();
        skxdAdminDictionaryExample.createCriteria();
        mode.addAttribute("input", input);
        mode.addAttribute("inputList", inputList);
        mode.addAttribute("staticTypeList", staticTypeList);
        mode.addAttribute("project", project);
        mode.addAttribute("step", step);
        return "/template/addInput";
    }


    @RequestMapping(value = "/addInput")
    @ResponseBody
    public ReturnResult addInput(Model model, @RequestBody  SkxdTemplateInput input) {
        ReturnResult result = null;
        int flag = inputService.saveOrUpdate(input);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }


    @RequestMapping(value = "/deleteInput")
    @ResponseBody
    public ReturnResult deleteInput(String ids) {
        ReturnResult result = null;
        int flag = inputService.delete(ids);
        if (flag == 0) {
            result = ReturnResultUtil.returnFail("操作失败");
        } else {
            result = ReturnResultUtil.returnSuccess();
        }
        return result;
    }

    @RequestMapping(value = "/preview")
    public String preview1(String projectId, ModelMap modelMap) {
        modelMap.addAttribute("projectId", projectId);
        return "/template/preview";
    }

    @RequestMapping(value = "/upMove")
    @ResponseBody
    public int upMove(String id, Model model) {
        int r = stepService.upMove(id);
        return r;
    }

    @RequestMapping(value = "/upMove4Input")
    @ResponseBody
    public void upMove4Input(String id, Model model) {
        inputService.upMove(id);
    }

    @RequestMapping("/previewProject")
    public void test(String projectId, HttpServletResponse response, HttpServletRequest request) {
//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//		String content=basePath+"/project/generatorProject?projectId="+projectId+"&userId=111&deviceId=221212";
//		Qrcode handler = new Qrcode();
//		handler.setQrcodeErrorCorrect('M');
//		handler.setQrcodeEncodeMode('B');
//		handler.setQrcodeVersion(7);
//		System.out.println(content);
//		byte[] contentBytes = new byte[0];
//		try {
//			contentBytes = content.getBytes("UTF-8");
//			BufferedImage bufImg = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);
//			Graphics2D gs = bufImg.createGraphics();
//			gs.setBackground(Color.WHITE);
//			gs.clearRect(0, 0, 140, 140);
//			//设定图像颜色：BLACK
//			gs.setColor(Color.BLACK);
//			//设置偏移量  不设置肯能导致解析出错
//			int pixoff = 3;
//			//输出内容：二维码
//			if(contentBytes.length > 0 && contentBytes.length < 124) {
//				boolean[][] codeOut = handler.calQrcode(contentBytes);
//				for(int i = 0; i < codeOut.length; i++) {
//					for(int j = 0; j < codeOut.length; j++) {
//						if(codeOut[j][i]) {
//							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff,3, 3);
//						}
//					}
//				}
//			} else {
//				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,120 ]. ");
//			}
//			gs.dispose();
//			bufImg.flush();
//			ImageIO.write(bufImg, "JPEG", response.getOutputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    }
}
