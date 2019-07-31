package lingpipe;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.JointClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.util.AbstractExternalizable;

public class TLingpipeTestClassify {
    static String text = "船舶纵向滑道下水崩墩现象研究 刘　宏 ,吴　忠 ,翟高进 ,谭新东 ,郭　林关键词:船舶;船舶纵向滑道下水;崩墩;有限元;变截面弹性支座梁摘　要:为避免船舶纵向滑道下水过程中由于拆除支墩顺序不合理引发崩墩而造成船体外板局部因受力过大 ,发生变形或者直接破坏 , 运用有限元分析与实船验证相结合的方法对 57 000 DWT 散货船崩墩现象进行研究 ,并对拆除支墩顺序进行优化设计 , 采用优化的拆除支墩方案 , 没有发生崩墩现象。　　船舶下水方式的选择要根据船厂的设施、船舶尺寸吨位、船厂工艺等因素确定[1]。本公司使用船舶纵向滑道下水,为避免由于拆除支墩顺序不合理而引发崩墩现象,运用有限元分析方法对崩墩的原因进行探讨 ,并对拆除支墩顺序进行优化设计。1　崩墩解决思路　　57000DWT散货船船舶纵向下水时,在拆除中墩过程中,在机舱位置处边墩发生崩墩现象,并造成部分区域支墩坍塌,船体产生振动并发生巨大响声,试航后进坞发现,船体外板产生严重变形。为了保证拆除支墩过程中船舶的安全 ,应预先采用有限元分析方法对下述情况进行预报 。　　1)拆除支墩过程中下水船舶的总纵弯矩和剪力的分布和变化情况;如果船舶承载了大于其极限承载能力的总纵弯矩 ,则会导致船舶甲板或者底板的破坏 ,危及下水船舶的安全。　　2)拆除支墩过程中支墩反力的大小与分布情况;支墩力将引起船体的局部变形 ,局部支墩力过大将引起船体结构的永久性变形 。　　3)拆除支墩过程中支墩强度破坏或失稳;部分支墩极可能会被压溃 ,船底压力会转移到相邻支墩,从而引起连锁反应,造成大面积区域的支墩发生崩墩,使下水船舶处于不稳定状态 。2　原支墩布置及拆除方案　　船舶坐墩状态下支墩布置图。下水船舶由中墩 、第一边墩 、第二边墩 、第三边墩和滑板左右对称支撑 。公司原用的船舶纵向下水拆除支墩步骤如下。　　1)先拆除中墩 ,拆除中墩时 ,拆墩人员分为两组 ,第一组人员从船艉向船舯拆除中墩 ,第二组人员人从船舯向般艏拆除中墩;　　2)拆除完中墩后开始拆除边墩 ,拆墩人员分为两组 ,两组人员由船舶尾部向首部沿船台左右对称拆除第一排边墩;　　3)第一排边墩拆除完成后 ,两组人员由尾部向首部对称拆除第二排边墩;　　4)第二排边墩拆除完成后 ,两组人员由尾部向首部对称拆除第三排边墩 ,直至边墩全部拆完;当边墩全部拆除后 ,船舶完全由滑板支撑。公司在拆除 57 000 DWT 散货船舯墩时 ,经 常发生崩墩现象 ,给船舶纵向滑道下水埋下了安全隐患。3　力学模型　　基于薄壁梁弯矩理论并结合实际拆除支墩工艺,拆除支墩力学模型为变截面弹性支座梁力学模型[3-6]。如图2所示,将下水船舶简化为一维变截面梁,刚度为EI1(x);边界条件为两端自由;自身重量分布为P1(x);船舶与船台之间的相互作用靠支墩来传递 ,支墩用单向受压的弹簧来模拟,刚度为Ki,弹簧顶部与船舶连接,支墩底部刚性固定,每个等效支墩的自身重量为 P i 。拆除支墩过程用改变支墩的弹簧刚度来模拟 ,如果某肋位处的支墩拆除或者支墩发生脱离 ,则此处的弹簧 刚度为 0。　　从表 1和图 4中可见:①序号 1～2区域内中墩敲完后,最大支墩反力位于38号肋位处,支墩反力高达;②肋位38号处只有第一边墩,没有第二边墩和第三边墩,由于拆除支墩区域较少 ,当此处中墩敲完 ,大部分力由第一边墩承受。所以38号肋位处及其周边区域内的边墩具拆除支墩区域最大支墩力 。　　注:序号为拆除支墩的顺序,拆除支墩区域为肋位范围有发生崩墩的危险。57000DWT散货船实船除支墩过程中,在机舱位置处(38号肋位区域)的边墩发生崩墩,有限元仿真计算结果与实际情况比较吻合 。可见 ,有限元计算结果可以较真实地反映拆除支墩过程中支墩力 、弯矩和剪力的变化。　5　支墩拆除顺序优化设计 　　优化后的57000DWT散货船纵向下水拆除支墩顺序为:拆除中墩时,拆除中墩人员分为两组,第一组人员从船舯向船艉拆除,第二组人员从船舯向般艏拆除,两组同时进行两种敲墩方案支墩力变化对比。可见:在 1 ～ 6区域 ,中墩拆除完后最大支墩力基本没有变化 ,在5 000kN 左右 ,弯矩 、剪力和位移变化也较小 ,具有较好的稳定性;当区域 7中墩拆除完,最大值从 5283kN增加到9862kN,此时由于其他区域中墩已经敲完,船底与滑板紧密接触,由于船舶滑板相对与边墩来说承受的力的比例较大,边墩受力较小,FR38号助位崩墩危险较小。进行船舶后续下水时 ,中墩敲击顺序为新方案 ,敲中墩时没有发生崩墩现象。6　结论　　1)有限元计算软件可以准确计算和预测拆除支墩过程中支墩反力 、船舶弯矩和船舶剪力的变化。　　2)优化后的中墩拆除方案有效避免了崩墩现象的发生。　　3)由于尾部支墩受力较大 ,布置于尾部区域的支墩结构强度应该明显大于货舱区域和首部区域的支墩结构强度。";

    // static String text ="";
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        LMClassifier classifier = (LMClassifier) AbstractExternalizable
                .readObject(new File("d:\\data\\lingpipeTrain.model"));
        JointClassification classify = classifier.classify(text);
        String bestCategory = classify.bestCategory();
        System.out.println(bestCategory);
    }
}
