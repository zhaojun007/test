package bayes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.hankcs.hanlp.classification.models.NaiveBayesModel;

public class TClassifyTrainByFolder1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String content = "船舶在风、流环境下的操纵性数字模型于升杰，朱克强，赵金鹏，沈小龙，张 亚，张长永关键词: 船舶操纵性;MMG模型;仿真摘要:系统地论述船舶操纵仿真数学模型及计算机模拟，并以MMG操纵运动数学模型及相关的系列实验结果为基础，建立单(双)桨方形舵(流线型舵、单板舵)运输船舶的基本模型，以及在水动力、螺旋桨推力、舵力及其力矩、静水、风、流中的操纵运动模型，导出该模型的无因次化方程组，选择欧拉积分法，积分求解该方程组。利用VB程序模拟了船舶回转运动，其计算结果基本符合实际情况，最后对结果进行了分析。0 引 言　　船舶作为水上运输的一种工具，和其他运输工具一样，它的安全性和经济性［1］是最为重要且最为令人关注的性能。船舶操纵性［2］是船舶安全航行的一种重要性能，它对于航运安全有非常重要的影响。尤其是近些年来，随着航运业的迅速发展。船舶吨位急剧增大，船舶航速不断提高，航道的拥挤，使船舶航运安全问题变得尤为突出。同时，现代海难事故造成巨大的人员伤亡和财产损失，而大部分原因是由于驾驶员对船舶操纵性掌握不够，且不能及时准确地应对海上突发状况造成的。对于船舶操纵性研究的主要方面是船舶保持和改变其航速、航向及位置的能力［3］，与航行的安全性与经济性密切相关。　　船舶操纵包括3种含义:保持航向、改变航向和改变航速［4］。船舶的操纵性预报是在船舶的初始设计阶段，根据包含船舶(包含螺旋桨和舵)的各项参数，计算出来的船舶操纵性能参数，使设计者对于船舶操纵性能［5］具有一个量化的指标，从而判断出船舶操纵性能的好坏，这也是对于船舶操纵性研究的主要目的之一。1 船舶运动的水动力模型1. 1 MMG模型　　MMG 模型是由日本船舶操纵运动数学模型　　小组提出，其主要研究方法是根据各项流体动力的成因及物理意义，将其表达为分别作用在船体、螺旋桨、舵上的流体动力及其间的相互干扰，是一种水动力模型，属于非线性数学模型［7］。主要用于船舶回转过程和各种激烈操纵运动时的数学模拟，其模拟计算结果的精确度明显高于线性模型。1. 2 MMG模型中采用的坐标系　　MMG模型仅考虑船舶在静水面的水平操纵运动情况，假定船舶航行在无限深广的水域，船体为刚体，忽略船舶摇荡［8］的影响。建立个坐标系:一个是固定坐标x0y0，固连于地球;另一个是运动坐标系G－xy，固连于船体。图1双坐标系下的船舶运动根据坐标系建立的运动方程在运动坐标系中船舶运动方程式(为避免寻找重心的麻烦，将坐标系的原点记于船中处)为:XG为船舶在船前进方向所受的力;YG为船舶垂直于船舷方向所受的力;IZ船体绕船体重心的转动惯性矩;NG船舶绕船体重心的转动力。2 风、流模型2. 1 流压模型　　在均匀流场下考虑流体对船舶运动的影响是将流速 Ve 分解到船舶动坐标系的 Gx 和 Gy 轴，可得:2. 2 风压模型　　风对船的作用力大小主要与船的上层建筑及其布局、风向和风速大小有关。　　式中:为空气密度;Ar，AL分别为船舶水线以上船体的正投影面积和侧投影面积;VW，θr分别为相对风速和相对风舷角;CWX，CWY，CWN为纵向风压力系数、横向风压力系数及力矩系数，数值由风洞试验得，若无实验数据，可由 Isherwood的回归方程求得。3 船舶在各种情况下的旋回圈及分析3. 1 左旋回与右旋回特性　　船舶转舵前做等速直航运动，当船舶舵角δ=35°(右满舵)比δ=－35°(左满舵)时船舶的回转圈要大，由于船舶自身存在操作的灵敏度和惯性力问题，船舶向左转与向右转其回转圈大小不一样，且右舵回转圈更大。3. 2 流影响下的回转性能　　在均匀流场中，船舶对水的旋回运动情况与静水中相同，也就是说船舶对水的回转圈大小不变。但对地回转圈却在流的方向上漂移，且漂移速度等于流速。所以流越急，这种漂移引起的变形也就越大。因此船舶在受限水域内转向一定要考虑流的影响，在静水中操作时可以参考船舶旋回性试验资料，在有流水域内，一般顺流操舵时机应适当提前，逆流操舵时机应适当滞后。3. 3 风影响下的回转性能　　船舶在操舵前保持等速直航，当船舶受到了风舷角风力后，船舶成螺旋线形向上运动，由于风是具有阵性所以船舶受力按一定规律变化，轨迹图上重心点的疏密情况不同。本文试验数据参照 “育英”轮模型的风洞试验。4 结 语 　　1)船舶左旋回圈和右旋回圈的大小不一样，且右旋回圈更大。即左舵和右舵操纵性能不一样，操舵时应充分考虑其差异。　　2)在均匀流场中，船舶对水的旋回运动情况与静水中相同，即回转圈大小不变。　　3)在有流水域内船舶会随水流一起漂移，所以一般顺流操舵的时机应适当提前，逆流操舵的时机应适当滞后。　　4)在受风环境下船舶运动轨迹上的点的疏密不同 (由于风具有阵性，风力大时船舶运动速度高，计算机上显示的点较疏，相反显示的点较密)。";
        // String content="";
        NaiveBayesClassifier1 bayesClassifier = new NaiveBayesClassifier1();
        // bayesClassifier1.train("D:\\test2\\X64-release-215\\keData\\trainData");
        bayesClassifier.train("D:\\test2\\X64-release-200\\keData\\trainData");
        String classify = bayesClassifier.classify(content);
        NaiveBayesModel naiveBayesModel = bayesClassifier.getNaiveBayesModel();
        System.out.println(classify);

        FileOutputStream os = new FileOutputStream("D:\\model.data");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(naiveBayesModel);
        oos.flush();
        oos.close();
        System.out.println("序列化成功！");
    }
}
