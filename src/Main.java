adascfzximport javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {


        Map treeMap = new TreeMap();
        treeMap.put("1",55);
        treeMap.put("3",33);
        treeMap.put("4",22);
        treeMap.put("2",64);
        treeMap.put("5",51);

        System.out.println("Коллекция сортируется по ключам:");
        printMap(treeMap);

        System.out.println("Самое простое решение (если java нормально делать это не умеет):");
        printMap(mirrorMap(treeMap));


        new MyWindow();

    }

    private static Map mirrorMap(Map treeMap) {
        Map mirrorMap = new TreeMap();
        Object [] arr = treeMap.keySet().toArray();

        for (int i =0; i < treeMap.size();   i++) {
            mirrorMap.put(treeMap.get(arr[i]), arr[i]);
        }
        return mirrorMap;
    }

    private static void printMap(Map treeMap) {
        for (Object entry: treeMap.entrySet()) {
            System.out.println(entry);
        }
    }


    static class MyWindow {
        private final JButton button;
        private final JTextField textField;

        public MyWindow() {
            JFrame frame = new JFrame();
            frame.setSize(400, 500);
            frame.setLocationRelativeTo(null);
            frame.setTitle("The window is for message for you");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setDefaultLookAndFeelDecorated(true);
            frame.setBackground(Color.GRAY);
            frame.setForeground(Color.WHITE);
            frame.setLayout(new FlowLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setRows(25);
            textArea.setColumns(30);
            JScrollPane jscrlp = new JScrollPane(textArea);


            textField = new JTextField(30 );
            textField.setColumns(30);
            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(textArea.getText()+"\n\n"+textField.getText());
                    textField.setText("");
                }
            });



            button = new JButton("Send my message!");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(textArea.getText()+"\n\n"+textField.getText());
                    textField.setText("");}} );

            frame.getContentPane().add(jscrlp);
            frame.getContentPane().add(textField);
            frame.getContentPane().add(button);
            frame.setVisible(true);
        }
    }

}
