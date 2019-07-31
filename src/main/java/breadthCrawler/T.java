package breadthCrawler;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.io.exporter.api.ExportController;
import org.gephi.io.importer.api.Container;
import org.gephi.io.importer.api.ContainerFactory;
import org.gephi.layout.plugin.AutoLayout;
import org.gephi.layout.plugin.force.StepDisplacement;
import org.gephi.layout.plugin.force.yifanHu.YifanHuLayout;
import org.gephi.layout.plugin.forceAtlas.ForceAtlasLayout;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.gephi.ranking.api.Ranking;
import org.gephi.ranking.api.RankingController;
import org.gephi.ranking.api.Transformer;
import org.gephi.ranking.plugin.transformer.AbstractColorTransformer;
import org.gephi.statistics.plugin.GraphDistance;
import org.openide.util.Lookup;

public class T {
public  void main(String[] args) {
    ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
    pc.newProject();

    GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();
    
    RankingController rankingController = Lookup.getDefault().lookup(RankingController.class);
    
    AttributeModel attributeModel = Lookup.getDefault().lookup(AttributeController.class).getModel();
    
    DirectedGraph graph = graphModel.getDirectedGraph();

    Node n0 = graphModel.factory().newNode("n0");
    n0.getNodeData().setLabel("n0");
    Node n1 = graphModel.factory().newNode("n1");
    n1.getNodeData().setLabel("n1");
    Edge edge = graphModel.factory().newEdge(n0, n1, 1f, true);


    graph.addNode(n0);
    graph.addNode(n1);
    graph.addEdge(edge);


    for(int i = 0 ; i < 100; i++) {
       Node ntmp = graphModel.factory().newNode("tmp" + i);
       Edge edgetmp = graphModel.factory().newEdge(n0, ntmp, 1f, true);
       ntmp.getAttributes().setValue("type", "概念");
       graph.addNode(ntmp);
       graph.addEdge(edgetmp);
    }

    System.out.println("Nodes: " + graph.getNodeCount());
    System.out.println("Edges: " + graph.getEdgeCount());

    //Layout for 15 seconds
    AutoLayout autoLayout = new AutoLayout(20, TimeUnit.SECONDS);
    autoLayout.setGraphModel(graphModel);
    YifanHuLayout firstLayout = new YifanHuLayout(null, new StepDisplacement(1f));
    ForceAtlasLayout secondLayout = new ForceAtlasLayout(null);
    AutoLayout.DynamicProperty adjustBySizeProperty = AutoLayout.createDynamicProperty("forceAtlas.adjustSizes.name", Boolean.TRUE, 0.1f);//True after 10% of layout time
    AutoLayout.DynamicProperty repulsionProperty = AutoLayout.createDynamicProperty("forceAtlas.repulsionStrength.name", new Double(500.), 0f);//500 for the complete period
    autoLayout.addLayout(firstLayout, 0.9f);
    autoLayout.addLayout(secondLayout, 0.1f, new AutoLayout.DynamicProperty[]{adjustBySizeProperty, repulsionProperty});
    autoLayout.execute();
    
    
    Ranking degreeRanking = rankingController.getModel().getRanking(Ranking.NODE_ELEMENT, Ranking.DEGREE_RANKING);
    AbstractColorTransformer colorTransformer = (AbstractColorTransformer) rankingController.getModel().getTransformer(Ranking.NODE_ELEMENT, Transformer.RENDERABLE_COLOR);
    colorTransformer.setColors(new Color[]{new Color(255), new Color(51)});
    rankingController.transform(degreeRanking,colorTransformer);
    
    
    
    AttributeColumn centralityColumn = attributeModel.getNodeTable().getColumn(GraphDistance.BETWEENNESS);
  /*  Ranking centralityRanking = rankingController.getModel().getRanking(Ranking.NODE_ELEMENT, centralityColumn.getId());
    AbstractSizeTransformer sizeTransformer = (AbstractSizeTransformer) rankingController.getModel().getTransformer(Ranking.NODE_ELEMENT, Transformer.RENDERABLE_SIZE);
    sizeTransformer.setMinSize(3);
    sizeTransformer.setMaxSize(10);
    rankingController.transform(centralityRanking,sizeTransformer);*/
    
    //Export pdf & gexf
    ExportController ec = Lookup.getDefault().lookup(ExportController.class);
    try {

        File pdfFile = new File("/tmp/data.pdf");
        File gexfFile = new File("D://data//data.gexf");

        pdfFile.getParentFile().mkdirs();
        gexfFile.getParentFile().mkdirs();
        ec.exportFile(pdfFile);
        ec.exportFile(gexfFile);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
}
