package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Data
@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-a", "--author"}, description = "输入作者名", interactive = true, arity = "0..1" ,echo = true)
    private String author = "yue";

    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输出文本", interactive = true, arity = "0..1" ,echo = true)
    private String outputText = "求和结果";

    /**
     * 是否循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, description = "循环", interactive = true, arity = "0..1" ,echo = true)
    private boolean loop = false;

    @Override
    public Integer call() throws Exception{
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
            MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }

}
