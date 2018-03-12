
package Calculations;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation extends javax.swing.JFrame {
	private double ans;
	private static final String digit = "-?\\d+(\\.\\d+)?(E-?\\d+)?";
    public Calculation() {
        initComponents();
    }
    private String trimmer(String exp) throws NumberFormatException{
        Matcher m;
        Pattern p;
        p = Pattern.compile("\\([^\\(\\)]*\\)");
        while(exp.matches(".*\\(.*\\).*")){
            m = p.matcher(exp);
            m.find();
            String g = m.group(0);
            exp = exp.replace(g,trimmer(g.substring(1,g.length()-1)));
        }
        p = Pattern.compile("((sin)|(cos)|(tan)|(ln)|(log))"+digit);
        while(exp.matches(".*((sin)|(cos)|(tan)|(ln)|(log))"+digit+".*")){
            System.out.println("exp:"+exp);
            m = p.matcher(exp);
            m.find();
            String g = m.group(0);
            System.out.println(g);
            exp = exp.replace(g,String.valueOf(varSetter(g)));
        }
        p = Pattern.compile(digit+"[√\\^]"+digit);
        while(exp.matches(".*"+digit+"[√\\^]"+digit+"+.*")){
            m = p.matcher(exp);
            m.find();
            String g = m.group(0);
            exp = exp.replace(g,String.valueOf(varSetter(g)));
        }
        p = Pattern.compile(digit+"[\\*\\/]"+digit);
        while(exp.matches(".*"+digit+"[\\*\\/]"+digit+"+.*")){
            m = p.matcher(exp);
            m.find();
            String g = m.group(0);
            exp = exp.replace(g,String.valueOf(varSetter(g)));
        }
        p = Pattern.compile(digit+"(\\+|-)"+digit);
        while(exp.matches(".*(\\d+(\\.\\d+)?)(\\+|-)"+digit+".*")){
            m = p.matcher(exp);
            m.find();
            String g = m.group(0);
            exp = exp.replace(g,String.valueOf(varSetter(g)));
        }
        return exp;
    }
    private double varSetter(String t) throws NumberFormatException{
        String oporator = null;
        double res = 0;
        double firstnum;
        double secondnum = 0;
        Pattern p;
        Matcher m;
        if(t.matches("((sin)|(cos)|(tan)|(ln)|(log))"+digit)){
            p = Pattern.compile("((sin)|(cos)|(tan)|(ln)|(log))");
            m = p.matcher(t);
            m.find();
            oporator = m.group(0);
            p = Pattern.compile(digit);
            m = p.matcher(t);
            m.find();
            firstnum = Double.parseDouble(m.group(0));
        }
        else if(t.matches(digit)){
            firstnum = Double.parseDouble(t);
            oporator = "+";
            secondnum = 0.0;
        }
        else if(t.matches("(-?\\d+(\\.\\d+)?)[√\\^\\+\\/\\*-]")){
            p = Pattern.compile(digit);
            m = p.matcher(t);
            m.find();
            firstnum = Double.parseDouble(m.group(0));
            p = Pattern.compile("[√\\^\\+\\/\\*-]");
            m = p.matcher(t);
            m.find();
            oporator = m.group(0);
            secondnum = "+".equals(oporator)||"-".equals(oporator)?0:1;
        }
        else if(t.matches(digit+"[√\\^\\+\\/\\*-]"+digit)){
            p = Pattern.compile(digit);
            m = p.matcher(t);
            m.find();
            firstnum = Double.parseDouble(m.group(0));
            t = t.replaceFirst(m.group(0),"");
            p = Pattern.compile("[√\\^\\+\\/\\*-]");
            m = p.matcher(t);
            m.find();
            oporator = m.group(0);
            if(oporator.equals("-"))t = t.replaceFirst("-", "");
            p = Pattern.compile(digit);
            m = p.matcher(t);
            m.find();
            System.out.println(m.group(0));
            secondnum = Double.parseDouble(m.group(0));
        }
        else{
            firstnum = 0.0;
            secondnum = 0.0;
            oporator = "+";
        }
        System.out.println("oporator: "+oporator);
        if("sin".equals(oporator))res = Math.sin(firstnum);
        if("cos".equals(oporator))res = Math.cos(firstnum);
        if("tan".equals(oporator))res = Math.tan(firstnum);
        if("ln".equals(oporator))res = Math.log(firstnum);
        if("log".equals(oporator))res = Math.log10(firstnum);
        if("-".equals(oporator))res = firstnum-secondnum;
        if("/".equals(oporator))res = firstnum/secondnum;
        if("+".equals(oporator))res = firstnum+secondnum;
        if("*".equals(oporator))res = firstnum*secondnum;
        if("^".equals(oporator))res = Math.pow(firstnum,secondnum);
        if("√".equals(oporator))res = Math.pow(secondnum,1/firstnum);
        return res;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        result = new javax.swing.JTextField();
        cal1 = new javax.swing.JButton();
        cal4 = new javax.swing.JButton();
        cal2 = new javax.swing.JButton();
        cal5 = new javax.swing.JButton();
        cal3 = new javax.swing.JButton();
        cal6 = new javax.swing.JButton();
        calsog = new javax.swing.JButton();
        calminus = new javax.swing.JButton();
        cal8 = new javax.swing.JButton();
        cal0 = new javax.swing.JButton();
        cal9 = new javax.swing.JButton();
        caldot = new javax.swing.JButton();
        calmult = new javax.swing.JButton();
        caldiv = new javax.swing.JButton();
        cal7 = new javax.swing.JButton();
        calclear = new javax.swing.JButton();
        calans = new javax.swing.JButton();
        caleq = new javax.swing.JButton();
        calpow = new javax.swing.JButton();
        calsog1 = new javax.swing.JButton();
        calroot = new javax.swing.JButton();
        calpi = new javax.swing.JButton();
        cale = new javax.swing.JButton();
        calsog2 = new javax.swing.JButton();
        callog = new javax.swing.JButton();
        calln = new javax.swing.JButton();
        calsin = new javax.swing.JButton();
        calcos = new javax.swing.JButton();
        caltan = new javax.swing.JButton();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);

        result.setEditable(false);
        result.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        result.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        result.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        cal1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal1.setText("1");
        cal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal1ActionPerformed(evt);
            }
        });

        cal4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal4.setText("4");
        cal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal4ActionPerformed(evt);
            }
        });

        cal2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal2.setText("2");
        cal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal2ActionPerformed(evt);
            }
        });

        cal5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal5.setText("5");
        cal5.setToolTipText("");
        cal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal5ActionPerformed(evt);
            }
        });

        cal3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal3.setText("3");
        cal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal3ActionPerformed(evt);
            }
        });

        cal6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal6.setText("6");
        cal6.setToolTipText("");
        cal6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal6ActionPerformed(evt);
            }
        });

        calsog.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calsog.setText("+");
        calsog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calsogActionPerformed(evt);
            }
        });

        calminus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calminus.setText("-");
        calminus.setToolTipText("");
        calminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calminusActionPerformed(evt);
            }
        });

        cal8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal8.setText("8");
        cal8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal8ActionPerformed(evt);
            }
        });

        cal0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal0.setText("0");
        cal0.setToolTipText("");
        cal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal0ActionPerformed(evt);
            }
        });

        cal9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal9.setText("9");
        cal9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal9ActionPerformed(evt);
            }
        });

        caldot.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        caldot.setText(".");
        caldot.setToolTipText("");
        caldot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caldotActionPerformed(evt);
            }
        });

        calmult.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calmult.setText("*");
        calmult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calmultActionPerformed(evt);
            }
        });

        caldiv.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        caldiv.setText("/");
        caldiv.setToolTipText("");
        caldiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caldivActionPerformed(evt);
            }
        });

        cal7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cal7.setText("7");
        cal7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal7ActionPerformed(evt);
            }
        });

        calclear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calclear.setText("C");
        calclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calclearActionPerformed(evt);
            }
        });

        calans.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calans.setText("ans");
        calans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calansActionPerformed(evt);
            }
        });

        caleq.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        caleq.setText("=");
        caleq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caleqActionPerformed(evt);
            }
        });

        calpow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calpow.setText("X^Y");
        calpow.setActionCommand("^X");
        calpow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calpowActionPerformed(evt);
            }
        });

        calsog1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calsog1.setText("(");
        calsog1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calsog1ActionPerformed(evt);
            }
        });

        calroot.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calroot.setText("X√Y");
        calroot.setToolTipText("");
        calroot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calrootActionPerformed(evt);
            }
        });

        calpi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calpi.setText("π");
        calpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calpiActionPerformed(evt);
            }
        });

        cale.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cale.setText("e");
        cale.setActionCommand("\ueb96");
        cale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caleActionPerformed(evt);
            }
        });

        calsog2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calsog2.setText(")");
        calsog2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calsog2ActionPerformed(evt);
            }
        });

        callog.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        callog.setText("log");
        callog.setActionCommand("^X");
        callog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callogActionPerformed(evt);
            }
        });

        calln.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calln.setText("ln");
        calln.setToolTipText("");
        calln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callnActionPerformed(evt);
            }
        });

        calsin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calsin.setText("sin");
        calsin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calsinActionPerformed(evt);
            }
        });

        calcos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        calcos.setText("cos");
        calcos.setActionCommand("\ueb96");
        calcos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcosActionPerformed(evt);
            }
        });

        caltan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        caltan.setText("tan");
        caltan.setActionCommand("\ueb96");
        caltan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caltanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(result)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cal4)
                                            .addComponent(cal7)
                                            .addComponent(calclear))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cal5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cal8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cal0, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(calans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(caleq, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(caldot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cal6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cal9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(caldiv, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(calpi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(calmult, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(calroot, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(calminus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(calpow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cal1)
                                .addGap(18, 18, 18)
                                .addComponent(cal2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(cal3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calsog, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(calsog1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calsog2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(callog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calsin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calcos, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(caltan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cal3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calsog, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calsog1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calsog2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(callog, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cal1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cal2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cal4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cal5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cal6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calminus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cal7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cal8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cal9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calmult, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(calclear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calpow, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calln, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calroot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calsin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caldot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cal0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caldiv, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calpi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calcos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cale, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caleq, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calans, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caltan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        //some code goes here whatever...
    }//GEN-LAST:event_resultActionPerformed

    private void cal6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal6ActionPerformed
        result.setText(result.getText()+cal6.getText());
    }//GEN-LAST:event_cal6ActionPerformed

    private void cal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal1ActionPerformed
        result.setText(result.getText()+cal1.getText());
    }//GEN-LAST:event_cal1ActionPerformed

    private void cal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal2ActionPerformed
        result.setText(result.getText()+cal2.getText());
    }//GEN-LAST:event_cal2ActionPerformed

    private void cal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal3ActionPerformed
        result.setText(result.getText()+cal3.getText());
    }//GEN-LAST:event_cal3ActionPerformed

    private void cal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal4ActionPerformed
        result.setText(result.getText()+cal4.getText());
    }//GEN-LAST:event_cal4ActionPerformed

    private void calclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calclearActionPerformed
        result.setText("");
    }//GEN-LAST:event_calclearActionPerformed

    private void cal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal5ActionPerformed
        result.setText(result.getText()+cal5.getText());
    }//GEN-LAST:event_cal5ActionPerformed

    private void cal7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal7ActionPerformed
        result.setText(result.getText()+cal7.getText());
    }//GEN-LAST:event_cal7ActionPerformed

    private void cal8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal8ActionPerformed
        result.setText(result.getText()+cal8.getText());
    }//GEN-LAST:event_cal8ActionPerformed

    private void cal9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal9ActionPerformed
        result.setText(result.getText()+cal9.getText());
    }//GEN-LAST:event_cal9ActionPerformed

    private void cal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal0ActionPerformed
        result.setText(result.getText()+cal0.getText());
    }//GEN-LAST:event_cal0ActionPerformed

    private void calsogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calsogActionPerformed
        result.setText(result.getText()+calsog.getText());
    }//GEN-LAST:event_calsogActionPerformed

    private void calminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calminusActionPerformed
        result.setText(result.getText()+calminus.getText());
    }//GEN-LAST:event_calminusActionPerformed

    private void calmultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calmultActionPerformed
        result.setText(result.getText()+calmult.getText());
    }//GEN-LAST:event_calmultActionPerformed

    private void caldivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caldivActionPerformed
        result.setText(result.getText()+caldiv.getText());
    }//GEN-LAST:event_caldivActionPerformed

    private void caldotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caldotActionPerformed
        result.setText(result.getText()+caldot.getText());
    }//GEN-LAST:event_caldotActionPerformed

    private void calansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calansActionPerformed
        result.setText(result.getText()+calans.getText());
    }//GEN-LAST:event_calansActionPerformed

    private void caleqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caleqActionPerformed
       // try{
            result.setText(trimmer(result.getText().replaceAll("ee","e*e").replaceAll("ππ","π*π").replaceAll("\\)\\(",")*(").replaceAll("eπ","e*π").replaceAll("πe","π*e").replaceAll("ans",String.valueOf(ans)).replaceAll("e",String.valueOf(Math.E)).replaceAll(calpi.getText(),String.valueOf(Math.PI))));
        /*}
        catch(NumberFormatException e){
            result.setText("Error");
        }*/
        if(!"Error".equals(result.getText()))ans = Double.parseDouble(result.getText());
    }//GEN-LAST:event_caleqActionPerformed

    private void calpowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calpowActionPerformed
        result.setText(result.getText()+"^");
    }//GEN-LAST:event_calpowActionPerformed

    private void calsog1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calsog1ActionPerformed
        result.setText(result.getText()+"(");
    }//GEN-LAST:event_calsog1ActionPerformed

    private void calrootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calrootActionPerformed
        result.setText(result.getText()+"√");
    }//GEN-LAST:event_calrootActionPerformed

    private void calpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calpiActionPerformed
        result.setText(result.getText()+calpi.getText());
    }//GEN-LAST:event_calpiActionPerformed

    private void calsog2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calsog2ActionPerformed
        result.setText(result.getText()+")");
    }//GEN-LAST:event_calsog2ActionPerformed

    private void caleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caleActionPerformed
        result.setText(result.getText()+"e");
    }//GEN-LAST:event_caleActionPerformed

    private void callogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callogActionPerformed
        result.setText(result.getText()+"log");
    }//GEN-LAST:event_callogActionPerformed

    private void callnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callnActionPerformed
        result.setText(result.getText()+"ln");
    }//GEN-LAST:event_callnActionPerformed

    private void calsinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calsinActionPerformed
        result.setText(result.getText()+"sin");
    }//GEN-LAST:event_calsinActionPerformed

    private void calcosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcosActionPerformed
        result.setText(result.getText()+"cos");
    }//GEN-LAST:event_calcosActionPerformed

    private void caltanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caltanActionPerformed
        result.setText(result.getText()+"tan");
    }//GEN-LAST:event_caltanActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton cal0;
    private javax.swing.JButton cal1;
    private javax.swing.JButton cal2;
    private javax.swing.JButton cal3;
    private javax.swing.JButton cal4;
    private javax.swing.JButton cal5;
    private javax.swing.JButton cal6;
    private javax.swing.JButton cal7;
    private javax.swing.JButton cal8;
    private javax.swing.JButton cal9;
    private javax.swing.JButton calans;
    private javax.swing.JButton calclear;
    private javax.swing.JButton calcos;
    private javax.swing.JButton caldiv;
    private javax.swing.JButton caldot;
    private javax.swing.JButton cale;
    private javax.swing.JButton caleq;
    private javax.swing.JButton calln;
    private javax.swing.JButton callog;
    private javax.swing.JButton calminus;
    private javax.swing.JButton calmult;
    private javax.swing.JButton calpi;
    private javax.swing.JButton calpow;
    private javax.swing.JButton calroot;
    private javax.swing.JButton calsin;
    private javax.swing.JButton calsog;
    private javax.swing.JButton calsog1;
    private javax.swing.JButton calsog2;
    private javax.swing.JButton caltan;
    private javax.swing.JTextField result;
    // End of variables declaration//GEN-END:variables

}
