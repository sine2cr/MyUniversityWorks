package com.javaWebLearn;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jisq extends JFrame {

//private static final long serialVersionUID=ABORT  ;

    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton jiaButton = new JButton("+");
    JButton jianButton = new JButton("-");
    JButton chengButton = new JButton("*");
    JButton chuButton = new JButton("/");
    JButton dengButton = new JButton("=");
    JButton backButton = new JButton("CLEAR");
    JButton cButton = new JButton("C");
    //先设置按钮

    public double op1;
    public double op2;
    //先设置两个操作数

    public int current = 0;
    //操作符


    private boolean opEnd = false;
    //判断第一个数是否结束

    public static final int JIA = 0;
    public static final int JIAN = 1;
    public static final int CHENG = 2;
    public static final int CHU = 3;


    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JTextField result = new JTextField(20);
//显示框


    public jisq() {
        initPanel2();
        initPanel3();

        //按钮5排，算一个panel

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(5, 4));
        panel1.add(panel2, BorderLayout.CENTER);// 设置位置

        panel1.add(panel3, BorderLayout.NORTH);// 设置位置

        getContentPane().add(panel1);
        addActionListeners();
        setSize(260, 260);
        setLocation(500, 300);
        setVisible(true);
        setDefaultCloseOperation(jisq.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("计算器");
    }

    private void initPanel2() {//数字面板
        // 把组件添加到相应的panel上
        panel2.add(b7);
        panel2.add(b8);
        panel2.add(b9);
        panel2.add(b4);
        panel2.add(b5);
        panel2.add(b6);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b0);
        panel2.add(jianButton);
        panel2.add(chuButton);
        panel2.add(chengButton);
        panel2.add(jiaButton);
        panel2.add(dengButton);
    }

    private void initPanel3() {

        panel3.setLayout(new GridLayout(2, 1));
        //一行一列
        panel3.add(result);
        panel4.setLayout(new GridLayout(1, 2));
        panel4.add(backButton);
        panel4.add(cButton);
        panel3.add(panel4);
        // panel3.setPreferredSize(new Dimension(260,65));
    }

    private void addActionListeners() {//每个按钮的监听器
        ActionHandler c = new ActionHandler();
        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);
        b5.addActionListener(c);
        b6.addActionListener(c);
        b7.addActionListener(c);
        b8.addActionListener(c);
        b9.addActionListener(c);
        jiaButton.addActionListener(c);
        dengButton.addActionListener(c);
        chengButton.addActionListener(c);
        chuButton.addActionListener(c);
        jianButton.addActionListener(c);
        backButton.addActionListener(c);
        cButton.addActionListener(c);
    }

    class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b0) {
                if (opEnd == false) {
                    result.setText("");
                }//表示清空
                result.setText(result.getText() + "0");
            }

            if (e.getSource() == b1) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "1");
                opEnd = true;
            }

            if (e.getSource() == b2) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "2");
                opEnd = true;
            }

            if (e.getSource() == b3) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "3");
                opEnd = true;
            }

            if (e.getSource() == b4) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "4");
                opEnd = true;
            }

            if (e.getSource() == b5) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "5");
                opEnd = true;
            }

            if (e.getSource() == b6) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "6");
                opEnd = true;
            }

            if (e.getSource() == b7) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "7");
                opEnd = true;
            }

            if (e.getSource() == b8) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "8");
                opEnd = true;
            }

            if (e.getSource() == b9) {
                if (opEnd == false) {
                    result.setText("");
                }
                result.setText(result.getText() + "9");
                opEnd = true;
            }

            try {

                if (e.getSource() == jiaButton) {
                    op1 = Integer.parseInt(result.getText());
                    // 2、说明操作数已经输入完毕
                    opEnd = false;
                    current = JIA;
                }

                if (e.getSource() == chengButton) {
                    op1 = Integer.parseInt(result.getText());
                    // 2、说明操作数已经输入完毕
                    opEnd = false;
                    current = CHENG;
                }

                if (e.getSource() == chuButton) {
                    op1 = Integer.parseInt(result.getText());
                    // 2、说明操作数已经输入完毕
                    opEnd = false;
                    current = CHU;
                }

                if (e.getSource() == jianButton) {
                    op1 = Integer.parseInt(result.getText());
                    // 2、说明操作数已经输入完毕
                    opEnd = false;
                    current = JIAN;
                }

                if (e.getSource() == backButton) {
                    String s = result.getText();
                    result.setText("");
                    for (int i = 0; i < s.length() - 1; i++) {
                        char a = s.charAt(i);
                        result.setText(result.getText() + a);
                    }

                }
                if (e.getSource() == cButton) {
                    result.setText("0");
                    opEnd = false;
                }

                if (e.getSource() == dengButton) {
                    op2 = Integer.parseInt(result.getText());
                    switch (current) {
                        case JIA:
                            result.setText(op1 + op2 + "");
                            break;
                        case JIAN:
                            result.setText(op1 - op2 + "");
                            break;
                        case CHENG:
                            result.setText(op1 * op2 + "");
                            break;
                        case CHU:
                            if (op2 == 0) {
                                result.setText("被除数不能为零！");
                                break;
                            }
                            result.setText(op1 / op2 + "");
                            break;
                    }
                    opEnd = false;
                }
            } catch (Exception e1) {
                result.setText("Wrong");
                opEnd = false;
            }
        }

    }



    public static void main(String[] args) {
        jisq c = new jisq();// 生成类的实例

    }

}
