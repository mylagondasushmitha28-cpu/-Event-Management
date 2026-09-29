
package eventregistration;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRegistrationAWT extends Frame implements ActionListener {

    // =========================================================
    // COLORS
    // =========================================================

    private Color headerColor = new Color(35, 55, 80);
    private Color panelColor = new Color(245, 247, 250);
    private Color sectionColor = new Color(225, 232, 240);
    private Color buttonColor = new Color(55, 90, 120);
    private Color clearColor = new Color(110, 120, 130);
    private Color textColor = new Color(35, 35, 35);

    // =========================================================
    // FONTS
    // =========================================================

    private Font titleFont =
            new Font("Arial", Font.BOLD, 24);

    private Font subtitleFont =
            new Font("Arial", Font.PLAIN, 13);

    private Font sectionFont =
            new Font("Arial", Font.BOLD, 15);

    private Font labelFont =
            new Font("Arial", Font.BOLD, 12);

    private Font normalFont =
            new Font("Arial", Font.PLAIN, 12);

    private Font buttonFont =
            new Font("Arial", Font.BOLD, 12);

    // =========================================================
    // TEXT FIELDS
    // =========================================================

    private TextField txtEventName;
    private TextField txtEventDate;
    private TextField txtLocation;
    private TextField txtCapacity;

    private TextField txtParticipantName;
    private TextField txtEmail;
    private TextField txtPhone;

    private TextField txtEventId;
    private TextField txtParticipantId;
    private TextField txtRegistrationId;

    // =========================================================
    // OUTPUT
    // =========================================================

    private TextArea output;

    // =========================================================
    // BUTTONS
    // =========================================================

    private Button btnAddEvent;
    private Button btnViewEvents;
    private Button btnSearchEvent;

    private Button btnAddParticipant;
    private Button btnViewParticipants;

    private Button btnRegister;
    private Button btnViewEventParticipants;

    private Button btnUpdateEvent;
    private Button btnCancelEvent;
    private Button btnCancelRegistration;

    private Button btnCountParticipants;

    private Button btnClear;
    private Button btnExit;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public EventRegistrationAWT() {

        setTitle("Event Registration Management System");

        setSize(1100, 720);

        setBackground(Color.WHITE);

        setLayout(new BorderLayout(10, 10));

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        Panel header = createHeader();

        add(header, BorderLayout.NORTH);

        // -----------------------------------------------------
        // MAIN AREA
        // -----------------------------------------------------

        Panel mainPanel = new Panel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(
                new GridLayout(1, 2, 10, 0)
        );

        // Left side
        Panel leftPanel = createInputPanel();

        // Right side
        Panel rightPanel = createOutputPanel();

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        // -----------------------------------------------------
        // FOOTER
        // -----------------------------------------------------

        Panel footer = createFooter();

        add(footer, BorderLayout.SOUTH);

        // -----------------------------------------------------
        // WINDOW CLOSE
        // -----------------------------------------------------

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =========================================================
    // HEADER
    // =========================================================

    private Panel createHeader() {

        Panel header = new Panel();

        header.setBackground(headerColor);

        header.setLayout(
                new GridLayout(2, 1)
        );

        Label title = new Label(
                "EVENT REGISTRATION MANAGEMENT SYSTEM",
                Label.CENTER
        );

        title.setFont(titleFont);
        title.setForeground(Color.WHITE);

        Label subtitle = new Label(
                "Manage Events  |  Participants  |  Registrations",
                Label.CENTER
        );

        subtitle.setFont(subtitleFont);
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(subtitle);

        return header;
    }

    // =========================================================
    // INPUT PANEL
    // =========================================================

    private Panel createInputPanel() {

        Panel container = new Panel();

        container.setBackground(panelColor);

        container.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(6, 10, 6, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;

        int row = 0;

        // -----------------------------------------------------
        // EVENT DETAILS
        // -----------------------------------------------------

        addSectionTitle(
                container,
                gbc,
                "EVENT DETAILS",
                row++
        );

        txtEventName = new TextField();
        txtEventDate = new TextField();
        txtLocation = new TextField();
        txtCapacity = new TextField();

        addField(
                container,
                gbc,
                "Event Name:",
                txtEventName,
                row++
        );

        addField(
                container,
                gbc,
                "Event Date:",
                txtEventDate,
                row++
        );

        addField(
                container,
                gbc,
                "Location:",
                txtLocation,
                row++
        );

        addField(
                container,
                gbc,
                "Maximum Capacity:",
                txtCapacity,
                row++
        );

        // -----------------------------------------------------
        // PARTICIPANT DETAILS
        // -----------------------------------------------------

        addSectionTitle(
                container,
                gbc,
                "PARTICIPANT DETAILS",
                row++
        );

        txtParticipantName = new TextField();
        txtEmail = new TextField();
        txtPhone = new TextField();

        addField(
                container,
                gbc,
                "Participant Name:",
                txtParticipantName,
                row++
        );

        addField(
                container,
                gbc,
                "Email:",
                txtEmail,
                row++
        );

        addField(
                container,
                gbc,
                "Phone:",
                txtPhone,
                row++
        );

        // -----------------------------------------------------
        // REGISTRATION DETAILS
        // -----------------------------------------------------

        addSectionTitle(
                container,
                gbc,
                "REGISTRATION DETAILS",
                row++
        );

        txtEventId = new TextField();
        txtParticipantId = new TextField();
        txtRegistrationId = new TextField();

        addField(
                container,
                gbc,
                "Event ID:",
                txtEventId,
                row++
        );

        addField(
                container,
                gbc,
                "Participant ID:",
                txtParticipantId,
                row++
        );

        addField(
                container,
                gbc,
                "Registration ID:",
                txtRegistrationId,
                row++
        );

        // -----------------------------------------------------
        // INFORMATION
        // -----------------------------------------------------

        Label info = new Label(
                "Date format: YYYY-MM-DD"
        );

        info.setFont(
                new Font("Arial", Font.ITALIC, 11)
        );

        info.setForeground(
                new Color(90, 90, 90)
        );

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;

        container.add(info, gbc);

        return container;
    }

    // =========================================================
    // ADD SECTION TITLE
    // =========================================================

    private void addSectionTitle(
            Panel panel,
            GridBagConstraints gbc,
            String title,
            int row) {

        Label label = new Label(title);

        label.setFont(sectionFont);

        label.setForeground(textColor);

        label.setBackground(sectionColor);

        gbc.gridx = 0;
        gbc.gridy = row;

        gbc.gridwidth = 2;

        gbc.weightx = 1.0;

        panel.add(label, gbc);
    }

    // =========================================================
    // ADD FIELD
    // =========================================================

    private void addField(
            Panel panel,
            GridBagConstraints gbc,
            String text,
            TextField field,
            int row) {

        Label label = new Label(text);

        label.setFont(labelFont);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = row;

        gbc.weightx = 0.35;

        panel.add(label, gbc);

        field.setFont(normalFont);

        gbc.gridx = 1;
        gbc.gridy = row;

        gbc.weightx = 0.65;

        panel.add(field, gbc);
    }

    // =========================================================
    // OUTPUT PANEL
    // =========================================================

    private Panel createOutputPanel() {

        Panel panel = new Panel();

        panel.setBackground(Color.WHITE);

        panel.setLayout(
                new BorderLayout(5, 5)
        );

        // -----------------------------------------------------
        // OUTPUT TITLE
        // -----------------------------------------------------

        Label title = new Label(
                "DATABASE RESULTS",
                Label.CENTER
        );

        title.setFont(sectionFont);

        title.setBackground(sectionColor);

        panel.add(title, BorderLayout.NORTH);

        // -----------------------------------------------------
        // OUTPUT AREA
        // -----------------------------------------------------

        output = new TextArea();

        output.setFont(
                new Font("Courier New", Font.PLAIN, 12)
        );

        output.setEditable(false);

        output.setBackground(
                new Color(250, 250, 250)
        );

        panel.add(output, BorderLayout.CENTER);

        // -----------------------------------------------------
        // BUTTON PANEL
        // -----------------------------------------------------

        Panel buttonPanel = new Panel();

        buttonPanel.setBackground(panelColor);

        buttonPanel.setLayout(
                new GridLayout(6, 2, 6, 6)
        );

        btnAddEvent =
                createButton("Add Event");

        btnViewEvents =
                createButton("View All Events");

        btnSearchEvent =
                createButton("Search Event");

        btnAddParticipant =
                createButton("Add Participant");

        btnViewParticipants =
                createButton("View Participants");

        btnRegister =
                createButton("Register Participant");

        btnViewEventParticipants =
                createButton("View Event Participants");

        btnUpdateEvent =
                createButton("Update Event");

        btnCancelEvent =
                createButton("Cancel Event");

        btnCancelRegistration =
                createButton("Cancel Registration");

        btnCountParticipants =
                createButton("Count Participants");

        btnClear =
                createButton("Clear Fields");

        buttonPanel.add(btnAddEvent);
        buttonPanel.add(btnViewEvents);

        buttonPanel.add(btnSearchEvent);
        buttonPanel.add(btnAddParticipant);

        buttonPanel.add(btnViewParticipants);
        buttonPanel.add(btnRegister);

        buttonPanel.add(btnViewEventParticipants);
        buttonPanel.add(btnUpdateEvent);

        buttonPanel.add(btnCancelEvent);
        buttonPanel.add(btnCancelRegistration);

        buttonPanel.add(btnCountParticipants);
        buttonPanel.add(btnClear);

        panel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        // -----------------------------------------------------
        // ACTION LISTENERS
        // -----------------------------------------------------

        btnAddEvent.addActionListener(this);
        btnViewEvents.addActionListener(this);
        btnSearchEvent.addActionListener(this);
        btnAddParticipant.addActionListener(this);
        btnViewParticipants.addActionListener(this);
        btnRegister.addActionListener(this);
        btnViewEventParticipants.addActionListener(this);
        btnUpdateEvent.addActionListener(this);
        btnCancelEvent.addActionListener(this);
        btnCancelRegistration.addActionListener(this);
        btnCountParticipants.addActionListener(this);
        btnClear.addActionListener(this);

        return panel;
    }

    // =========================================================
    // CREATE BUTTON
    // =========================================================

    private Button createButton(String text) {

        Button button = new Button(text);

        button.setFont(buttonFont);

        button.setBackground(buttonColor);

        button.setForeground(Color.WHITE);

        return button;
    }

    // =========================================================
    // FOOTER
    // =========================================================

    private Panel createFooter() {

        Panel footer = new Panel();

        footer.setBackground(headerColor);

        footer.setLayout(
                new FlowLayout(FlowLayout.RIGHT)
        );

        btnExit = new Button("EXIT");

        btnExit.setFont(buttonFont);

        btnExit.setBackground(
                new Color(150, 60, 60)
        );

        btnExit.setForeground(Color.WHITE);

        btnExit.addActionListener(this);

        footer.add(btnExit);

        return footer;
    }

    // =========================================================
    // ACTION PERFORMED
    // =========================================================

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        try {

            if (source == btnAddEvent) {

                addEvent();

            } else if (source == btnViewEvents) {

                viewAllEvents();

            } else if (source == btnSearchEvent) {

                searchEvent();

            } else if (source == btnAddParticipant) {

                addParticipant();

            } else if (source == btnViewParticipants) {

                viewParticipants();

            } else if (source == btnRegister) {

                registerParticipant();

            } else if (source == btnViewEventParticipants) {

                viewEventParticipants();

            } else if (source == btnUpdateEvent) {

                updateEvent();

            } else if (source == btnCancelEvent) {

                cancelEvent();

            } else if (source == btnCancelRegistration) {

                cancelRegistration();

            } else if (source == btnCountParticipants) {

                countParticipants();

            } else if (source == btnClear) {

                clearFields();

            } else if (source == btnExit) {

                System.exit(0);
            }

        } catch (Exception ex) {

            output.setText(
                    "ERROR\n\n" +
                    ex.getMessage()
            );
        }
    }

    // =========================================================
    // ADD EVENT
    // =========================================================

    private void addEvent() throws SQLException {

        if (txtEventName.getText().trim().equals("") ||
            txtEventDate.getText().trim().equals("") ||
            txtLocation.getText().trim().equals("") ||
            txtCapacity.getText().trim().equals("")) {

            output.setText(
                    "Please fill all Event Details."
            );

            return;
        }

        String sql =
                "INSERT INTO events " +
                "(event_name, event_date, location, " +
                "maximum_capacity, status) " +
                "VALUES (?, ?, ?, ?, 'Open')";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtEventName.getText().trim()
        );

        ps.setDate(
                2,
                Date.valueOf(
                        txtEventDate.getText().trim()
                )
        );

        ps.setString(
                3,
                txtLocation.getText().trim()
        );

        ps.setInt(
                4,
                Integer.parseInt(
                        txtCapacity.getText().trim()
                )
        );

        int rows = ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Event added successfully."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // VIEW EVENTS
    // =========================================================

    private void viewAllEvents()
            throws SQLException {

        String sql =
                "SELECT event_id, event_name, " +
                "event_date, location, " +
                "maximum_capacity, status " +
                "FROM events " +
                "ORDER BY event_date";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        output.setText("");

        output.append(
                "============================================================\n"
        );

        output.append(
                "                    ALL EVENTS\n"
        );

        output.append(
                "============================================================\n\n"
        );

        boolean found = false;

        while (rs.next()) {

            found = true;

            output.append(
                    "Event ID       : " +
                    rs.getInt("event_id") +
                    "\n"
            );

            output.append(
                    "Event Name     : " +
                    rs.getString("event_name") +
                    "\n"
            );

            output.append(
                    "Date           : " +
                    rs.getDate("event_date") +
                    "\n"
            );

            output.append(
                    "Location       : " +
                    rs.getString("location") +
                    "\n"
            );

            output.append(
                    "Capacity       : " +
                    rs.getInt("maximum_capacity") +
                    "\n"
            );

            output.append(
                    "Status         : " +
                    rs.getString("status") +
                    "\n"
            );

            output.append(
                    "------------------------------------------------------------\n"
            );
        }

        if (!found) {

            output.append(
                    "No events found."
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    // =========================================================
    // SEARCH EVENT
    // =========================================================

    private void searchEvent()
            throws SQLException {

        String name =
                txtEventName.getText().trim();

        if (name.equals("")) {

            output.setText(
                    "Enter Event Name to search."
            );

            return;
        }

        String sql =
                "SELECT * FROM events " +
                "WHERE event_name LIKE ? " +
                "ORDER BY event_date";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                "%" + name + "%"
        );

        ResultSet rs =
                ps.executeQuery();

        output.setText("");

        boolean found = false;

        while (rs.next()) {

            found = true;

            output.append(
                    "Event ID   : " +
                    rs.getInt("event_id") +
                    "\n"
            );

            output.append(
                    "Name       : " +
                    rs.getString("event_name") +
                    "\n"
            );

            output.append(
                    "Date       : " +
                    rs.getDate("event_date") +
                    "\n"
            );

            output.append(
                    "Location   : " +
                    rs.getString("location") +
                    "\n"
            );

            output.append(
                    "Capacity   : " +
                    rs.getInt("maximum_capacity") +
                    "\n"
            );

            output.append(
                    "Status     : " +
                    rs.getString("status") +
                    "\n"
            );

            output.append(
                    "------------------------------------------------------------\n"
            );
        }

        if (!found) {

            output.setText(
                    "No matching event found."
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    // =========================================================
    // ADD PARTICIPANT
    // =========================================================

    private void addParticipant()
            throws SQLException {

        if (txtParticipantName.getText()
                .trim().equals("") ||

            txtEmail.getText()
                .trim().equals("") ||

            txtPhone.getText()
                .trim().equals("")) {

            output.setText(
                    "Please fill all Participant Details."
            );

            return;
        }

        String sql =
                "INSERT INTO participants " +
                "(name, email, phone) " +
                "VALUES (?, ?, ?)";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtParticipantName.getText().trim()
        );

        ps.setString(
                2,
                txtEmail.getText().trim()
        );

        ps.setString(
                3,
                txtPhone.getText().trim()
        );

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Participant added successfully."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // VIEW PARTICIPANTS
    // =========================================================

    private void viewParticipants()
            throws SQLException {

        String sql =
                "SELECT * FROM participants " +
                "ORDER BY participant_id";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        output.setText("");

        output.append(
                "============================================================\n"
        );

        output.append(
                "                  ALL PARTICIPANTS\n"
        );

        output.append(
                "============================================================\n\n"
        );

        boolean found = false;

        while (rs.next()) {

            found = true;

            output.append(
                    "Participant ID : " +
                    rs.getInt("participant_id") +
                    "\n"
            );

            output.append(
                    "Name           : " +
                    rs.getString("name") +
                    "\n"
            );

            output.append(
                    "Email          : " +
                    rs.getString("email") +
                    "\n"
            );

            output.append(
                    "Phone          : " +
                    rs.getString("phone") +
                    "\n"
            );

            output.append(
                    "------------------------------------------------------------\n"
            );
        }

        if (!found) {

            output.append(
                    "No participants found."
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    // =========================================================
    // REGISTER PARTICIPANT
    // =========================================================

    private void registerParticipant()
            throws SQLException {

        if (txtEventId.getText()
                .trim().equals("") ||

            txtParticipantId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Event ID and Participant ID."
            );

            return;
        }

        String sql =
                "INSERT INTO registrations " +
                "(event_id, participant_id, " +
                "registration_date, status) " +
                "VALUES (?, ?, ?, 'Registered')";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                Integer.parseInt(
                        txtEventId.getText().trim()
                )
        );

        ps.setInt(
                2,
                Integer.parseInt(
                        txtParticipantId.getText().trim()
                )
        );

        // Java 7 compatible current date
        ps.setDate(
                3,
                new Date(
                        System.currentTimeMillis()
                )
        );

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Participant registered successfully."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // VIEW EVENT PARTICIPANTS
    // =========================================================

    private void viewEventParticipants()
            throws SQLException {

        if (txtEventId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Event ID."
            );

            return;
        }

        String sql =
                "SELECT p.participant_id, " +
                "p.name, p.email, p.phone, " +
                "r.registration_id, " +
                "r.registration_date, r.status " +
                "FROM participants p " +
                "JOIN registrations r " +
                "ON p.participant_id = " +
                "r.participant_id " +
                "WHERE r.event_id=? " +
                "ORDER BY p.name";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                Integer.parseInt(
                        txtEventId.getText().trim()
                )
        );

        ResultSet rs =
                ps.executeQuery();

        output.setText("");

        boolean found = false;

        while (rs.next()) {

            found = true;

            output.append(
                    "Registration ID : " +
                    rs.getInt("registration_id") +
                    "\n"
            );

            output.append(
                    "Participant ID  : " +
                    rs.getInt("participant_id") +
                    "\n"
            );

            output.append(
                    "Name            : " +
                    rs.getString("name") +
                    "\n"
            );

            output.append(
                    "Email           : " +
                    rs.getString("email") +
                    "\n"
            );

            output.append(
                    "Phone           : " +
                    rs.getString("phone") +
                    "\n"
            );

            output.append(
                    "Date            : " +
                    rs.getDate("registration_date") +
                    "\n"
            );

            output.append(
                    "Status          : " +
                    rs.getString("status") +
                    "\n"
            );

            output.append(
                    "------------------------------------------------------------\n"
            );
        }

        if (!found) {

            output.setText(
                    "No participants registered for this event."
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    // =========================================================
    // UPDATE EVENT
    // =========================================================

    private void updateEvent()
            throws SQLException {

        if (txtEventId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Event ID to update."
            );

            return;
        }

        String sql =
                "UPDATE events SET " +
                "event_name=?, " +
                "event_date=?, " +
                "location=?, " +
                "maximum_capacity=? " +
                "WHERE event_id=?";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtEventName.getText().trim()
        );

        ps.setDate(
                2,
                Date.valueOf(
                        txtEventDate.getText().trim()
                )
        );

        ps.setString(
                3,
                txtLocation.getText().trim()
        );

        ps.setInt(
                4,
                Integer.parseInt(
                        txtCapacity.getText().trim()
                )
        );

        ps.setInt(
                5,
                Integer.parseInt(
                        txtEventId.getText().trim()
                )
        );

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Event updated successfully."
            );

        } else {

            output.setText(
                    "Event ID not found."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // CANCEL EVENT
    // =========================================================

    private void cancelEvent()
            throws SQLException {

        if (txtEventId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Event ID."
            );

            return;
        }

        String sql =
                "UPDATE events SET " +
                "status='Cancelled' " +
                "WHERE event_id=?";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                Integer.parseInt(
                        txtEventId.getText().trim()
                )
        );

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Event cancelled successfully."
            );

        } else {

            output.setText(
                    "Event ID not found."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // CANCEL REGISTRATION
    // =========================================================

    private void cancelRegistration()
            throws SQLException {

        if (txtRegistrationId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Registration ID."
            );

            return;
        }

        String sql =
                "UPDATE registrations " +
                "SET status='Cancelled' " +
                "WHERE registration_id=?";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                Integer.parseInt(
                        txtRegistrationId.getText().trim()
                )
        );

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            output.setText(
                    "SUCCESS\n\n" +
                    "Registration cancelled successfully."
            );

        } else {

            output.setText(
                    "Registration ID not found."
            );
        }

        ps.close();
        con.close();
    }

    // =========================================================
    // COUNT PARTICIPANTS
    // =========================================================

    private void countParticipants()
            throws SQLException {

        if (txtEventId.getText()
                .trim().equals("")) {

            output.setText(
                    "Enter Event ID."
            );

            return;
        }

        String sql =
                "SELECT e.event_name, " +
                "e.maximum_capacity, " +
                "COUNT(r.registration_id) AS total " +
                "FROM events e " +
                "LEFT JOIN registrations r " +
                "ON e.event_id=r.event_id " +
                "AND r.status='Registered' " +
                "WHERE e.event_id=? " +
                "GROUP BY e.event_id, " +
                "e.event_name, " +
                "e.maximum_capacity";

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                Integer.parseInt(
                        txtEventId.getText().trim()
                )
        );

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            output.setText(
                    "============================================================\n" +
                    "                  PARTICIPANT COUNT\n" +
                    "============================================================\n\n" +

                    "Event Name              : " +
                    rs.getString("event_name") +

                    "\nRegistered Participants : " +
                    rs.getInt("total") +

                    "\nMaximum Capacity        : " +
                    rs.getInt("maximum_capacity") +

                    "\n============================================================"
            );

        } else {

            output.setText(
                    "Event ID not found."
            );
        }

        rs.close();
        ps.close();
        con.close();
    }

    // =========================================================
    // CLEAR FIELDS
    // =========================================================

    private void clearFields() {

        txtEventName.setText("");
        txtEventDate.setText("");
        txtLocation.setText("");
        txtCapacity.setText("");

        txtParticipantName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");

        txtEventId.setText("");
        txtParticipantId.setText("");
        txtRegistrationId.setText("");

        output.setText(
                "Ready...\n\n" +
                "Enter details and select an operation."
        );
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

   

        new EventRegistrationAWT();
    }
}