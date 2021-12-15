package cn.sheva.idea.plugin.template;

import com.alibaba.fastjson.JSON;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.util.HashMap;
import java.util.Map;

public class HelloAction extends AnAction {
    
    @Override
    public void actionPerformed(AnActionEvent event) {
        // your logic
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String txt = Messages.showInputDialog(project, "What is your name?", "Question", Messages.getQuestionIcon());
        
        if (txt != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", txt);
            Messages.showMessageDialog(project, JSON.toJSONString(map), "Information", Messages.getInformationIcon());
        }
    }
}
