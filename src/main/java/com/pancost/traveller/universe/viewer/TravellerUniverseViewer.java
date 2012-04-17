package com.pancost.traveller.universe.viewer;

import com.pancost.traveller.universe.builder.TravellerConstants;
import com.pancost.traveller.universe.frames.*;
import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.frames.FramesManager;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerUniverseViewer extends javax.swing.JFrame implements TravellerConstants {

    TransactionalGraph graphDB;
    Graph<Vertex,Edge> visGraph;
    FramesManager framesManager;
    ArrayList<Planet> planetList;

    public TravellerUniverseViewer() {
        graphDB = new Neo4jGraph("C:/traveller/graphdb");
        framesManager = new FramesManager(graphDB);
        visGraph = new SparseMultigraph<>();
        initComponents();
        
        Iterable<PlanetList> planetListIterable = framesManager.frameVertices(Index.VERTICES, "indexed", "YES", PlanetList.class);
        planetList = new ArrayList<>(planetListIterable.iterator().next().getPlanetList());
        
        DefaultListModel dlm = new DefaultListModel();
        for(Planet planet : planetList){
            dlm.addElement(planet.getDesignation());
        }
        /*for(Edge planetEdge : planets.getOutEdges(UtilityTypes.Planet.getProperty())){
            Vertex planet = planetEdge.getInVertex();
            dlm.addElement(planet.getProperty(PlanetProperties.DESIGNATION.getProperty()));
            planetList.add(planet);
            visGraph.addVertex(planet);
            for(Edge shiftEdge : planet.getOutEdges(ShiftTypes.Shift.getProperty())){
                Vertex otherPlanet = shiftEdge.getInVertex();
                if(!planetList.contains(otherPlanet)){
                    visGraph.addEdge(shiftEdge, planet, otherPlanet);
                }
            }
        }*/
        jPlanetList.setModel(dlm);
    }

    @Override
    public void dispose(){
        this.setVisible(false);
        graphDB.shutdown();
        System.exit(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLoadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPlanetList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jWorldSizeTextField = new javax.swing.JTextField();
        jSurfaceGravityTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSurvivalGearRequiredTextField = new javax.swing.JTextField();
        jPressureTextField = new javax.swing.JTextField();
        jAtmosphereTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jAverageTemperatureTextField = new javax.swing.JTextField();
        jTemperatureTypeTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTemperatureDescriptionTextArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jHydrographicPercentageTextField = new javax.swing.JTextField();
        jHydrographicDescriptionTextField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPopulationDescriptionTextField = new javax.swing.JTextField();
        jPopulationRangeTextField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLawInformationTextField = new javax.swing.JTextField();
        jLawDrugsTextField = new javax.swing.JTextField();
        jLawWeaponsTextField = new javax.swing.JTextField();
        jLawTechnologyTextField = new javax.swing.JTextField();
        jLawTravellersTextField = new javax.swing.JTextField();
        jLawPsionicsTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jGovernmentCommonContrabandTextField = new javax.swing.JTextField();
        jGovernmentTypeTextField = new javax.swing.JTextField();
        jGovernmentExamplesTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jGovernmentDescriptionTextArea = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jStarportBerthingCostTextField = new javax.swing.JTextField();
        jStarportQualityTextField = new javax.swing.JTextField();
        jStarportFuelTextField = new javax.swing.JTextField();
        jStarportFacilitiesTextField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jStarportBasesTextArea = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTechLevelDesignationTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTechLevelDescriptionTextArea = new javax.swing.JTextArea();
        graphViewport = new com.pancost.traveller.universe.viewer.TravellerGraphVisualization(visGraph);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Traveller Universe Viewer");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Designation"));
        jPanel2.setName("jPanel1"); // NOI18N

        jLoadButton.setText("Load Planet");
        jLoadButton.setName("jLoadButton"); // NOI18N
        jLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane1"); // NOI18N

        jPlanetList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jPlanetList.setName("jPlanetList"); // NOI18N
        jScrollPane2.setViewportView(jPlanetList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLoadButton)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Size"));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabel1.setText("WORLD_SIZE:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("SURFACE_GRAVITY:");
        jLabel2.setName("jLabel2"); // NOI18N

        jWorldSizeTextField.setName("jWorldSizeTextField"); // NOI18N

        jSurfaceGravityTextField.setName("jSurfaceGravityTextField"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSurfaceGravityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jWorldSizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jWorldSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSurfaceGravityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atmospheric Properties"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel3.setText("ATMOSPHERE:");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("PRESSURE:");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("SURVIVAL_GEAR_REQUIRED:");
        jLabel5.setName("jLabel5"); // NOI18N

        jSurvivalGearRequiredTextField.setName("jSurvivalGearRequiredTextField"); // NOI18N

        jPressureTextField.setName("jPressureTextField"); // NOI18N

        jAtmosphereTextField.setName("jAtmosphereTextField"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAtmosphereTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jPressureTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jSurvivalGearRequiredTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jAtmosphereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPressureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSurvivalGearRequiredTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperature"));
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel6.setText("TEMPERATURE_TYPE:");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText("AVERAGE_TEMPERATURE:");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("TEMPERATURE_DESCRIPTION:");
        jLabel8.setName("jLabel8"); // NOI18N

        jAverageTemperatureTextField.setName("jAverageTemperatureTextField"); // NOI18N

        jTemperatureTypeTextField.setName("jTemperatureTypeTextField"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTemperatureDescriptionTextArea.setColumns(20);
        jTemperatureDescriptionTextArea.setLineWrap(true);
        jTemperatureDescriptionTextArea.setRows(3);
        jTemperatureDescriptionTextArea.setWrapStyleWord(true);
        jTemperatureDescriptionTextArea.setName("jTemperatureDescriptionTextArea"); // NOI18N
        jScrollPane1.setViewportView(jTemperatureDescriptionTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTemperatureTypeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jAverageTemperatureTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTemperatureTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jAverageTemperatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hydrographics"));
        jPanel5.setName("jPanel5"); // NOI18N

        jLabel9.setText("HYDROGRAPHIC_PERCENTAGE:");
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText("HYDROGRAPHIC_DESCRIPTION:");
        jLabel10.setName("jLabel10"); // NOI18N

        jHydrographicPercentageTextField.setName("jHydrographicPercentageTextField"); // NOI18N

        jHydrographicDescriptionTextField.setName("jHydrographicDescriptionTextField"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHydrographicDescriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jHydrographicPercentageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jHydrographicPercentageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jHydrographicDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Population"));
        jPanel6.setName("jPanel6"); // NOI18N

        jLabel11.setText("POPULATION_RANGE:");
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setText("POPULATION_DESCRIPTION:");
        jLabel12.setName("jLabel12"); // NOI18N

        jPopulationDescriptionTextField.setName("jPopulationDescriptionTextField"); // NOI18N

        jPopulationRangeTextField.setName("jPopulationRangeTextField"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPopulationRangeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPopulationDescriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jPopulationRangeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jPopulationDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Law"));
        jPanel7.setName("jPanel7"); // NOI18N

        jLabel17.setText("LAW_WEAPONS:");
        jLabel17.setName("jLabel17"); // NOI18N

        jLabel18.setText("LAW_DRUGS:");
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel19.setText("LAW_INFORMATION:");
        jLabel19.setName("jLabel19"); // NOI18N

        jLabel20.setText("LAW_TECHNOLOGY:");
        jLabel20.setName("jLabel20"); // NOI18N

        jLabel21.setText("LAW_TRAVELLERS:");
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText("LAW_PSIONICS:");
        jLabel22.setName("jLabel22"); // NOI18N

        jLawInformationTextField.setName("jLawInformationTextField"); // NOI18N

        jLawDrugsTextField.setName("jLawDrugsTextField"); // NOI18N

        jLawWeaponsTextField.setName("jLawWeaponsTextField"); // NOI18N

        jLawTechnologyTextField.setName("jLawTechnologyTextField"); // NOI18N

        jLawTravellersTextField.setName("jLawTravellersTextField"); // NOI18N

        jLawPsionicsTextField.setName("jLawPsionicsTextField"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLawPsionicsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(jLawTravellersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(jLawTechnologyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(jLawInformationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(jLawDrugsTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(jLawWeaponsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLawWeaponsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLawDrugsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLawInformationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLawTechnologyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLawTravellersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLawPsionicsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Government"));
        jPanel8.setName("jPanel8"); // NOI18N

        jLabel13.setText("GOVERNMENT_TYPE:");
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText("GOVERNMENT_DESCRIPTION:");
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText("GOVERNMENT_EXAMPLES:");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setText("GOVERNMENT_COMMON_CONTRABAND:");
        jLabel16.setName("jLabel16"); // NOI18N

        jGovernmentCommonContrabandTextField.setName("jGovernmentCommonContrabandTextField"); // NOI18N

        jGovernmentTypeTextField.setName("jGovernmentTypeTextField"); // NOI18N

        jGovernmentExamplesTextField.setName("jGovernmentExamplesTextField"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jGovernmentDescriptionTextArea.setColumns(20);
        jGovernmentDescriptionTextArea.setLineWrap(true);
        jGovernmentDescriptionTextArea.setRows(3);
        jGovernmentDescriptionTextArea.setWrapStyleWord(true);
        jGovernmentDescriptionTextArea.setName("jGovernmentDescriptionTextArea"); // NOI18N
        jScrollPane3.setViewportView(jGovernmentDescriptionTextArea);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jGovernmentTypeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jGovernmentExamplesTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jGovernmentCommonContrabandTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGovernmentTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jGovernmentExamplesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jGovernmentCommonContrabandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Starport"));
        jPanel9.setName("jPanel9"); // NOI18N

        jLabel23.setText("STARPORT_QUALITY:");
        jLabel23.setName("jLabel23"); // NOI18N

        jLabel24.setText("STARPORT_BERTHING_COST:");
        jLabel24.setName("jLabel24"); // NOI18N

        jLabel25.setText("STARPORT_FUEL:");
        jLabel25.setName("jLabel25"); // NOI18N

        jLabel26.setText("STARPORT_FACILITIES:");
        jLabel26.setName("jLabel26"); // NOI18N

        jLabel27.setText("STARPORT_BASES:");
        jLabel27.setName("jLabel27"); // NOI18N

        jStarportBerthingCostTextField.setName("jStarportBerthingCostTextField"); // NOI18N

        jStarportQualityTextField.setName("jStarportQualityTextField"); // NOI18N

        jStarportFuelTextField.setName("jStarportFuelTextField"); // NOI18N

        jStarportFacilitiesTextField.setName("jStarportFacilitiesTextField"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jStarportBasesTextArea.setColumns(20);
        jStarportBasesTextArea.setLineWrap(true);
        jStarportBasesTextArea.setRows(3);
        jStarportBasesTextArea.setWrapStyleWord(true);
        jStarportBasesTextArea.setName("jStarportBasesTextArea"); // NOI18N
        jScrollPane5.setViewportView(jStarportBasesTextArea);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jStarportFacilitiesTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jStarportFuelTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jStarportQualityTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jStarportBerthingCostTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jStarportQualityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jStarportBerthingCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jStarportFuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jStarportFacilitiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Technology"));
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel28.setText("TECH_LEVEL_DESIGNATION:");
        jLabel28.setName("jLabel28"); // NOI18N

        jLabel29.setText("TECH_LEVEL_DESCRIPTION:");
        jLabel29.setName("jLabel29"); // NOI18N

        jTechLevelDesignationTextField.setName("jTechLevelDesignationTextField"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTechLevelDescriptionTextArea.setColumns(20);
        jTechLevelDescriptionTextArea.setLineWrap(true);
        jTechLevelDescriptionTextArea.setRows(5);
        jTechLevelDescriptionTextArea.setWrapStyleWord(true);
        jTechLevelDescriptionTextArea.setName("jTechLevelDescriptionTextArea"); // NOI18N
        jScrollPane4.setViewportView(jTechLevelDescriptionTextArea);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTechLevelDesignationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTechLevelDesignationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );

        graphViewport.setName("graphViewport"); // NOI18N

        javax.swing.GroupLayout graphViewportLayout = new javax.swing.GroupLayout(graphViewport);
        graphViewport.setLayout(graphViewportLayout);
        graphViewportLayout.setHorizontalGroup(
            graphViewportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        graphViewportLayout.setVerticalGroup(
            graphViewportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(graphViewport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(graphViewport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadButtonActionPerformed
        Planet planet = planetList.get(jPlanetList.getSelectedIndex());

        PlanetSize sizeNode = planet.getPlanetSize();
        jWorldSizeTextField.setText(sizeNode.getWorldSize());
        jSurfaceGravityTextField.setText(sizeNode.getSurfaceGravity());

        PlanetAtmosphere atmosphereNode = planet.getPlanetAtmosphere();
        jAtmosphereTextField.setText(atmosphereNode.getAtmosphere());
        jPressureTextField.setText(atmosphereNode.getPressure());
        jSurvivalGearRequiredTextField.setText(atmosphereNode.getSurvivalGearRequired());

        PlanetTemperature temperatureNode = planet.getPlanetTemperature();
        jAverageTemperatureTextField.setText(temperatureNode.getAverageTemperature());
        jTemperatureTypeTextField.setText(temperatureNode.getTemperatureType());
        jTemperatureDescriptionTextArea.setText(temperatureNode.getDescription());

        PlanetHydrographics hydrographicsNode = planet.getPlanetHydrographics();
        jHydrographicPercentageTextField.setText(hydrographicsNode.getPercentage());
        jHydrographicDescriptionTextField.setText(hydrographicsNode.getDescription());

        PlanetPopulation populationNode = planet.getPlanetPopulation();
        jPopulationRangeTextField.setText(populationNode.getPopulationRange());
        jPopulationDescriptionTextField.setText(populationNode.getDescription());

        PlanetGovernment governmentNode = planet.getPlanetGovernment();
        jGovernmentTypeTextField.setText(governmentNode.getType());
        jGovernmentDescriptionTextArea.setText(governmentNode.getDescription());
        jGovernmentExamplesTextField.setText(governmentNode.getExamples());
        jGovernmentCommonContrabandTextField.setText(governmentNode.getCommonContraband());

        PlanetLaw lawNode = planet.getPlanetLaw();
        jLawWeaponsTextField.setText(lawNode.getWeaponRestrictions());
        jLawDrugsTextField.setText(lawNode.getDrugRestrictions());
        jLawInformationTextField.setText(lawNode.getInformationRestrictions());
        jLawTechnologyTextField.setText(lawNode.getTechnologyRestrictions());
        jLawTravellersTextField.setText(lawNode.getTravellerRestrictions());
        jLawPsionicsTextField.setText(lawNode.getPsionicRestrictions());

        PlanetStarport starportNode = planet.getPlanetStarport();
        jStarportQualityTextField.setText(starportNode.getQuality());
        jStarportBerthingCostTextField.setText(starportNode.getBerthingCost());
        jStarportFuelTextField.setText(starportNode.getFuel());
        jStarportFacilitiesTextField.setText(starportNode.getFacilities());
        jStarportBasesTextArea.setText(starportNode.getBases());

        PlanetTechLevel techLevelNode = planet.getPlanetTechLevel();
        jTechLevelDesignationTextField.setText(techLevelNode.getDesignation());
        jTechLevelDescriptionTextArea.setText(techLevelNode.getDescription());
    }//GEN-LAST:event_jLoadButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TravellerUniverseViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pancost.traveller.universe.viewer.TravellerGraphVisualization graphViewport;
    private javax.swing.JTextField jAtmosphereTextField;
    private javax.swing.JTextField jAverageTemperatureTextField;
    private javax.swing.JTextField jGovernmentCommonContrabandTextField;
    private javax.swing.JTextArea jGovernmentDescriptionTextArea;
    private javax.swing.JTextField jGovernmentExamplesTextField;
    private javax.swing.JTextField jGovernmentTypeTextField;
    private javax.swing.JTextField jHydrographicDescriptionTextField;
    private javax.swing.JTextField jHydrographicPercentageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLawDrugsTextField;
    private javax.swing.JTextField jLawInformationTextField;
    private javax.swing.JTextField jLawPsionicsTextField;
    private javax.swing.JTextField jLawTechnologyTextField;
    private javax.swing.JTextField jLawTravellersTextField;
    private javax.swing.JTextField jLawWeaponsTextField;
    private javax.swing.JButton jLoadButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JList jPlanetList;
    private javax.swing.JTextField jPopulationDescriptionTextField;
    private javax.swing.JTextField jPopulationRangeTextField;
    private javax.swing.JTextField jPressureTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jStarportBasesTextArea;
    private javax.swing.JTextField jStarportBerthingCostTextField;
    private javax.swing.JTextField jStarportFacilitiesTextField;
    private javax.swing.JTextField jStarportFuelTextField;
    private javax.swing.JTextField jStarportQualityTextField;
    private javax.swing.JTextField jSurfaceGravityTextField;
    private javax.swing.JTextField jSurvivalGearRequiredTextField;
    private javax.swing.JTextArea jTechLevelDescriptionTextArea;
    private javax.swing.JTextField jTechLevelDesignationTextField;
    private javax.swing.JTextArea jTemperatureDescriptionTextArea;
    private javax.swing.JTextField jTemperatureTypeTextField;
    private javax.swing.JTextField jWorldSizeTextField;
    // End of variables declaration//GEN-END:variables

}
