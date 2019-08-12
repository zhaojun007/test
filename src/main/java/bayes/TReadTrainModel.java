package bayes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;

public class TReadTrainModel {
    public static void main(String[] args) {
        String content = "插件式可重配导弹总体设计集成优化框架研究\r\n" + 
                "(8)根据最终结果对总体方案进行改进或者择优。\r\n" + 
                "整个求解过程的操作序列可存储为集成优化框架中的一个解决方案，解决方案也可进一步转化为模板以便重用。多个解决方案的有机组合形成一个解决方案计划，框架通过解决方案计划来支持单优化问题的多解决方案运行，然后对最终的结果进行分析和比较，选出比较好的解决方案，为以后的解决方案选择提供参考。\r\n" + 
                "集成优化框架在初始化时只载入当前解决方案或者解决方案计划所需的模型、文件、算法等资源，能够有效降低框架运行负荷，提高优化效率。因此，对于不同的优化问题，框架能够灵活的自动重新配置，体现不同的模型/视图/控制（Model/View/Controller）体系。\r\n" + 
                "3 总体设计集成优化平台原型系统\r\n" + 
                "在插件式可重配导弹总体设计集成优化框架的指导下，我们实现了一个原型系统——导弹总体设计集成优化平台，并在与航天科技集团一院合作的项目中得到了应用，效果良好。该平台采用C/S架构，Java实现的服务器具有良好的跨平台特性，可运行于不同的高性能计算服务器上，提供了VP数据库服务以及组件命名和路由服务；VisualC++实现的客户端提供了灵活的优化工具和高性能的优化算法、实验设计工具和数据分析服务，以及多种工具软件集成插件。客户端软件运行于Windows平台上，符合设计人员日常工作习惯。\r\n" + 
                "插件集成规范与可重配解决方案表现形式是平台考虑的两个重要因素，下面概要介绍其实现方法。\r\n" + 
                "3.1 插件集成规范\r\n" + 
                "采用基于组件的设计（Component-BasedDesign，简称CBD）方法来设计各种插件。各种组件及中间件技术（COM/DCOM/COM+，JavaBeans/EJB，CORBA）的日趋成熟为组件提供了良好的跨网络/硬件平台/操作系统的、支持分布式应用的、标准化并且可扩展性非常强的实现途径。YijiaXu提出了一种基于CORBA的通用的集成分布仿真和优化模型的一般框架[6]，李妮等利用Globus网格服务搭建一个基于Web的虚拟样机分布式协同建模/仿真环境[7]。\r\n" + 
                "以优化算法插件为例，采用标准的接口定义语言（InterfaceDefinitionLanguage，简称IDL）给出算法插件的详细接口定义。\r\n" + 
                "只要组件实现了IOptAlgorithm接口并正确部署，就能被平台自动识别，作为优化的可选算法插件之一提供给设计人员使用。\r\n" + 
                "3.2 解决方案的XML存储\r\n" + 
                "在导弹总体设计集成优化平台中，因为数据传输的跨平台性以及异构模型集成存在的难度，我们采用XML作为可重配解决方案的标准格式，并设计了特定的解析器根据关键词提取数据，比如Solution代表解决方案节点，OptAlgorithm代表优化算法节点，Constraint代表一个约束条件节点。\r\n" + 
                "4 结论\r\n" + 
                "本文针对导弹总体设计集成和优化领域存在的问题，提出一种插件式可重配导弹总体设计集成优化框架，并实现了框架的一个原型系统，能有效地支持导弹总体设计和优化过程。\r\n" + 
                "在今后研究中，一方面继续原型系统的研发工作，完善插件集成规范；另一方面可以考虑充分利用组件的可重用性和可移植性，将平台功能扩展到网格体系结构或者面向服务的体系结构（Service-OrientedArchitecture，简称SOA）\r\n" + 
                "";
        NaiveBayesClassifier naiveBayesClassifier = null;
       // Map<String, String> map = new HashMap<>();
        try (FileInputStream is = new FileInputStream("D:\\data\\model.data")) {
            ObjectInputStream ois = new ObjectInputStream(is);
            NaiveBayesModel model = (NaiveBayesModel) ois.readObject();
            ois.close();
            naiveBayesClassifier = new NaiveBayesClassifier(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String classify = naiveBayesClassifier.classify(content);
        System.out.println(classify);
    }
}
