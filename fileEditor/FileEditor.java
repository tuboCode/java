//������һ�㶼���Զ�����
package com.cs.cn;

//������������Ҫ����
import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;

public class FileEditor extends JFrame { 

    //����һ��˽�е��ļ��ľ���·���ı������
    private JTextField selectField;  
    
    //����һ��˽�еı༭������
    private JTextArea editArea;      
    
    //����һ��˽�еġ����桱��ť����
    private JButton saveBtn;         
    
    //����һ��˽�еġ��������ť���� 
    private JButton openFileBtn;    

    //����һ��˽�еļ�¼Ŀ¼����������ʼֵΪ0 
    private int level = 0;          

    public FileEditor() {  
        this.init();
    }  

    private void init() {  
    
        //���ñ���Ϊ Editor 
        this.setTitle("Editor");
        
        //��������Ĵ�С
        this.setBounds(300, 50, 600, 300);  

        /* 
         * ���ı��ߣ���·�������������ť 
         */ 
         
        //����һ��ѡ������
        selectField = new JTextField(40); 
        
        //����һ����ť����
        openFileBtn = new JButton("Browse");  
        
        //Ϊ�մ����İ�ť��Ӽ����¼�
        openFileBtn.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {  
                FileEditor.this.level = 0;  
                String path = selectField.getText();  
                
                // ���Ŀ¼�����ļ� 
                openDirOrFile(path.replaceAll("//", "\\\\"));  

				//String��replaceAll()�������ǲ���������ʽ����ȥƥ��ġ�
				// �����еġ�//����java�����б�����Ϊ��/��������\\\\����java�����б������ɡ�\\������Ҫ��������ʽת��Ϊ��\���� 
            }  
        });  
        
        //�½�һ�������֣��������������
        JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  
        
        //���û���ı�����ɫ
        upPanel.setBackground(Color.CYAN);  
        
        //��ѡ�����뻭����
        upPanel.add(selectField);

        //����ť���뻭����
        upPanel.add(openFileBtn); 

        //�������ڱ�������
        this.add(upPanel, BorderLayout.NORTH);  

        /* 
         * �����ı��༭���������뵽�������ֵ��м����� 
         */ 
        editArea = new JTextArea();  
        ScrollPane scollPanel = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);  
        scollPanel.add(editArea);  
        this.add(scollPanel, BorderLayout.CENTER);  

        /* 
         * �������水ť����Ϊ��ť��Ӽ����¼� 
         */ 
        saveBtn = new JButton("Save");  
        saveBtn.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {  
                // ���� 
                saveFile();  
            }
        }); 
        
        JPanel southPanel = new JPanel();  
        southPanel.setBackground(Color.green);  
        southPanel.add(saveBtn);  
        this.add(southPanel, BorderLayout.SOUTH);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
    }  

    /* 
     * �����ļ� 
     */ 
    private void saveFile() {  
        FileDialog fd = new FileDialog(this, "Save File");  
        
        //������Ҫ�����ļ��ĺ�׺
        fd.setFile("untitled.txt");  
        
        //����Ϊ�����桱ģʽ 
        fd.setMode(FileDialog.SAVE);  
        fd.setVisible(true);  
        
        //��ȡ�ļ��� 
        String fileName = fd.getFile();  
        
        //��ȡ�Ի���ĵ�ǰĿ¼ 
        String dir = fd.getDirectory(); 
        
        //����Ŀ¼�����ļ�������һ���ļ�����Ҫ�����Ŀ���ļ� 
        File newFile = new File(dir + File.separator + fileName);  
        PrintWriter pw = null;  
        try {  
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(  
                    newFile)));  

            String str = editArea.getText();  
            pw.println(str);  
            pw.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            pw.close();  
        }  
    }  

    /* 
     * ��Ŀ¼���ļ� 
     */ 
    private void openDirOrFile(String absolutePath) { 
    
        //absolutePath:ָ��Ŀ¼���ļ��ľ���·���� 
        File file = new File(absolutePath);  
        
        //�ж��ļ���Ŀ¼�Ƿ����
        if (!(file.exists())) {  
            editArea.setText("The file does not exist!");  
            
        //�ж��Ƿ���һ��Ŀ¼
        } else if (file.isDirectory()) {  
            editArea.setText(null);  
            showDir(file);  
            
        //�ж��Ƿ���һ���ļ�
        } else if (file.isFile()) {  
            try {  
                FileInputStream fis = new FileInputStream(file);  
                BufferedReader br = new BufferedReader(new InputStreamReader(  
                        fis));  
                String str = null;  
                editArea.setText(null);  
                while ((str = br.readLine()) != null) {  
                    editArea.append(str + "\r\n");  
                }  
                br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  

    /* 
     * ���Ŀ¼,��������ͼ 
     */ 
    private void showDir(File directory)
    {
        File[] files = directory.listFiles();
        int len = files.length;
        for(int i = 0; i < len; i++)
        {
            if(files[i].isDirectory())
            {
                for(int j = 0; j < this.level; j++)
                {
                    editArea.append("    ");
                }
                editArea.append("|-- "+ files[i].getName() + " (Folder)\r\n");
                this.level++;
                showDir(files[i]);
                this.level--;
            }
            else if(files[i].isFile())
            {
                for(int j = 0; j < this.level; j++)
                {
                    editArea.append("    ");
                }
                editArea.append("|-- " + files[i].getAbsolutePath() + "\r\n");
            }
        }
    }

    /* 
     * ���ԣ����������������Ч�� 
     */ 
    public static void main(String[] args) {  
        new FileEditor();  
    }  
}  