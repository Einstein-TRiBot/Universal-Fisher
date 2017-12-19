package scripts.UniversalFisher.graphics;

import static scripts.UniversalFisher.data.Constants.*;

import javax.swing.JFrame;
import org.tribot.api.General;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSArea;

import scripts.UniversalFisher.data.Vars;


/**
 * This GUI was designed with NetBeans.
 * 
 * I highly recommend using this IDE for GUI design, so you can focus more on the actual design and less on the implementation details.
 * 
 * @author Einstein
 * 
 * _______________________________________________________________________________________________________________________________________
 */
public class GUI extends JFrame {
public GUI() { initComponents(); }
private void initComponents() {
selectFishButtonGroup = new javax.swing.ButtonGroup();
disposalMethodButtonGroup = new javax.swing.ButtonGroup();
panel0 = new javax.swing.JPanel();
title = new javax.swing.JLabel();
panel2 = new javax.swing.JPanel();
bank = new javax.swing.JRadioButton();
drop = new javax.swing.JRadioButton();
panel1 = new javax.swing.JPanel();
shrimp = new javax.swing.JRadioButton();
sardine = new javax.swing.JRadioButton();
trout = new javax.swing.JRadioButton();
pike = new javax.swing.JRadioButton();
lobster = new javax.swing.JRadioButton();
tuna = new javax.swing.JRadioButton();
leaping = new javax.swing.JRadioButton();
mackerel = new javax.swing.JRadioButton();
monkfish = new javax.swing.JRadioButton();
shark = new javax.swing.JRadioButton();
start = new javax.swing.JButton();
locationWarning = new javax.swing.JLabel();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
setName("frame");
setResizable(false);
panel0.setBackground(new java.awt.Color(0, 153, 204));
title.setFont(new java.awt.Font("Arial Black", 0, 24));
title.setText("UNIVERSAL FISHER");
javax.swing.GroupLayout panel0Layout = new javax.swing.GroupLayout(panel0);
panel0.setLayout(panel0Layout);
panel0Layout.setHorizontalGroup(
panel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel0Layout.createSequentialGroup()
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(24, 24, 24)));
panel0Layout.setVerticalGroup(
panel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel0Layout.createSequentialGroup()
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap()));
panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fish disposal method:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 0, 14)));
disposalMethodButtonGroup.add(bank);
bank.setText("Bank");
disposalMethodButtonGroup.add(drop);
drop.setText("Drop");
javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
panel2.setLayout(panel2Layout);
panel2Layout.setHorizontalGroup(
panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(panel2Layout.createSequentialGroup()
.addGap(41, 41, 41)
.addComponent(bank)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(drop)
.addGap(62, 62, 62)));
panel2Layout.setVerticalGroup(
panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(panel2Layout.createSequentialGroup()
.addContainerGap()
.addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(bank)
.addComponent(drop))
.addGap(0, 19, Short.MAX_VALUE)));
panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select fish:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 0, 14))); // NOI18N
selectFishButtonGroup.add(shrimp);
shrimp.setText("Shrimp/Anchovies");
shrimp.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
shrimpActionPerformed(evt);}});
selectFishButtonGroup.add(sardine);
sardine.setText("Sardine/Herring");
selectFishButtonGroup.add(trout);
trout.setText("Trout/Salmon");
selectFishButtonGroup.add(pike);
pike.setText("Pike");
selectFishButtonGroup.add(lobster);
lobster.setText("Lobster");
selectFishButtonGroup.add(tuna);
tuna.setText("Tuna/Swordfish");
tuna.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
tunaActionPerformed(evt);}});
selectFishButtonGroup.add(leaping);
leaping.setText("Mackerel/Cod/Bass");
selectFishButtonGroup.add(mackerel);
mackerel.setText("Monkfish");
mackerel.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
mackerelActionPerformed(evt);}});
selectFishButtonGroup.add(monkfish);
monkfish.setText("Shark");
selectFishButtonGroup.add(shark);
shark.setText("Leaping fish");
shark.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
sharkActionPerformed(evt);}});
javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
panel1.setLayout(panel1Layout);
panel1Layout.setHorizontalGroup(
panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(panel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(panel1Layout.createSequentialGroup()
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(sardine)
.addComponent(shrimp)
.addComponent(trout)
.addComponent(pike))
.addGap(39, 39, 39)
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(leaping)
.addComponent(shark)
.addComponent(mackerel)
.addComponent(monkfish)))
.addComponent(lobster)
.addComponent(tuna))
.addGap(37, 37, 37)));
panel1Layout.setVerticalGroup(
panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(panel1Layout.createSequentialGroup()
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(shrimp)
.addComponent(shark))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(sardine)
.addComponent(leaping))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(trout)
.addComponent(mackerel))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(pike)
.addComponent(monkfish))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(lobster)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(tuna)));
start.setBackground(new java.awt.Color(0, 153, 204));
start.setFont(new java.awt.Font("Arial Black", 0, 18));
start.setText("START");
start.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
startActionPerformed(evt);}});
locationWarning.setForeground(new java.awt.Color(204, 0, 0));
locationWarning.setText(" Start near the fishing spot.");
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(panel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
.addContainerGap())
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addGap(0, 0, Short.MAX_VALUE)
.addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(74, 74, 74))))
.addGroup(layout.createSequentialGroup()
.addGap(102, 102, 102)
.addComponent(locationWarning)
.addGap(0, 0, Short.MAX_VALUE)));
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(panel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(26, 26, 26)
.addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(30, 30, 30)
.addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(32, 32, 32)
.addComponent(locationWarning)
.addGap(18, 18, 18)
.addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(22, Short.MAX_VALUE)));
this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
shrimp.setActionCommand("shrimp");
sardine.setActionCommand("sardine");
trout.setActionCommand("trout");
pike.setActionCommand("pike");
lobster.setActionCommand("lobster");
tuna.setActionCommand("tuna");
leaping.setActionCommand("mackerel");
mackerel.setActionCommand("monkfish");
monkfish.setActionCommand("shark");
shark.setActionCommand("leaping");
bank.setActionCommand("bank");
drop.setActionCommand("drop");pack();}              
private void shrimpActionPerformed(java.awt.event.ActionEvent evt) {}                                      
private void tunaActionPerformed(java.awt.event.ActionEvent evt) {}                                    
private void mackerelActionPerformed(java.awt.event.ActionEvent evt) {}                                        
private void sharkActionPerformed(java.awt.event.ActionEvent evt) {} 
private void startActionPerformed(java.awt.event.ActionEvent evt) {        
String fishSelected = selectFishButtonGroup.getSelection().getActionCommand();
String disposalMethod = disposalMethodButtonGroup.getSelection().getActionCommand();
setVariables(fishSelected, disposalMethod);dispose();}   
private static void set(boolean usingSingleTool, int fishingTool, int consumables, String fishingAction,int[] fishingSpotID) {
Vars.get().usingSingleTool = usingSingleTool;
Vars.get().fishingTool = fishingTool;
Vars.get().consumables = consumables;
Vars.get().fishingAction = fishingAction;
Vars.get().fishingSpotID = fishingSpotID;}
public static void setVariables(String fishSelected, String disposalMethod) {
switch (fishSelected) {
case "shrimp": set(true, SMALL_FISHING_NET, SMALL_FISHING_NET, NET_ACTION, NET_BAIT_FISHING_SPOT); break;
case "sardine": set(false, FISHING_ROD, FISHING_BAIT, BAIT_ACTION, NET_BAIT_FISHING_SPOT); break;
case "trout": set(false, FLY_FISHING_ROD, FEATHER, LURE_ACTION, LURE_BAIT_FISHING_SPOT); break;
case "pike": set(false, FISHING_ROD, FISHING_BAIT, LURE_ACTION, LURE_BAIT_FISHING_SPOT);break;
case "lobster":set(true, LOBSTER_POT, LOBSTER_POT, CAGE_ACTION, CAGE_HARPOON_FISHING_SPOT);break;
case "tuna":set(true, HARPOON, HARPOON, HARPOON_ACTION, CAGE_HARPOON_FISHING_SPOT);break;
case "leaping":General.println("Barbarian fishing temp disabled!");break;
case "mackerel":set(true, BIG_FISHING_NET, BIG_FISHING_NET, NET_ACTION, NET_HARPOON_FISHING_SPOT);break;
case "monkfish":General.println("Monkfish fishing temp disabled");break;
case "shark":set(true, HARPOON, HARPOON, HARPOON_ACTION, NET_HARPOON_FISHING_SPOT);break;}
switch (disposalMethod) {
case "bank": Vars.get().dropFish = false; break;
case "drop": Vars.get().dropFish = true;break;}
Vars.get().fishingArea = new RSArea(Player.getPosition(), 7);
Vars.get().startingXP = Skills.getXP(Skills.SKILLS.FISHING);
Vars.get().variablesInitialized = true;}
private static final long serialVersionUID = 1L;                    
private javax.swing.JRadioButton bank;
private javax.swing.ButtonGroup disposalMethodButtonGroup;
private javax.swing.JRadioButton drop;
private javax.swing.JRadioButton leaping;
private javax.swing.JRadioButton lobster;
private javax.swing.JLabel locationWarning;
private javax.swing.JRadioButton mackerel;
private javax.swing.JRadioButton monkfish;
private javax.swing.JPanel panel0;
private javax.swing.JPanel panel1;
private javax.swing.JPanel panel2;
private javax.swing.JRadioButton pike;
private javax.swing.JRadioButton sardine;
private javax.swing.ButtonGroup selectFishButtonGroup;
private javax.swing.JRadioButton shark;
private javax.swing.JRadioButton shrimp;
private javax.swing.JButton start;
private javax.swing.JLabel title;
private javax.swing.JRadioButton trout;
private javax.swing.JRadioButton tuna;                  
}