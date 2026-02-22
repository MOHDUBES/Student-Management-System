import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagement extends JFrame implements ActionListener {

    JTextField nameField, courseField, marksField, idField;
    JTextArea displayArea;
    JButton addBtn, viewBtn, updateBtn, deleteBtn;

    Connection con;

    StudentManagement() {

        setTitle("Student Management System");
        setSize(600, 400);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("Course:"));
        courseField = new JTextField(10);
        add(courseField);

        add(new JLabel("Marks:"));
        marksField = new JTextField(5);
        add(marksField);

        addBtn = new JButton("Add");
        add(addBtn);

        add(new JLabel("ID:"));
        idField = new JTextField(5);
        add(idField);

        viewBtn = new JButton("View");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");

        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        displayArea = new JTextArea(10, 50);
        add(displayArea);

        addBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        connectDB();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "0786"
            );

            System.out.println("Connected Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

        try {

            // ✅ ADD
            if (e.getSource() == addBtn) {

                if (nameField.getText().isEmpty() ||
                        courseField.getText().isEmpty() ||
                        marksField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO students(name, course, marks) VALUES (?, ?, ?)"
                );

                pst.setString(1, nameField.getText());
                pst.setString(2, courseField.getText());
                pst.setInt(3, Integer.parseInt(marksField.getText()));

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student Added!");
            }

            // ✅ VIEW
            if (e.getSource() == viewBtn) {

                displayArea.setText("");

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM students");

                while (rs.next()) {
                    displayArea.append(
                            rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getString("course") + " | " +
                                    rs.getInt("marks") + "\n"
                    );
                }
            }

            // ✅ UPDATE
            if (e.getSource() == updateBtn) {

                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter ID!");
                    return;
                }

                PreparedStatement pst = con.prepareStatement(
                        "UPDATE students SET name=?, course=?, marks=? WHERE id=?"
                );

                pst.setString(1, nameField.getText());
                pst.setString(2, courseField.getText());
                pst.setInt(3, Integer.parseInt(marksField.getText()));
                pst.setInt(4, Integer.parseInt(idField.getText()));

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student Updated!");
            }

            // ✅ DELETE
            if (e.getSource() == deleteBtn) {

                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter ID!");
                    return;
                }

                PreparedStatement pst = con.prepareStatement(
                        "DELETE FROM students WHERE id=?"
                );

                pst.setInt(1, Integer.parseInt(idField.getText()));
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Student Deleted!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentManagement();
    }
}