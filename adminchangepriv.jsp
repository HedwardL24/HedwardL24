<!DOCTYPE html>
<html>
<head>
    <title>Manage User Privileges</title>
<link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
</head>
<body>
	<%@ include file="/headmenu3.jsp"%>
    <h2>Manage User Privileges</h2>
    <form method="post" action="updatePrivileges">
        <label for="userEmail">Select User:</label>
        <select id="userEmail" name="userEmail">
            <%-- This will be populated with user emails from the database --%>
            <% 
                java.sql.Connection conn = null;
                java.sql.PreparedStatement ps = null;
                java.sql.ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "Mereja0728$");
                    String query = "SELECT email, role FROM users";
                    ps = conn.prepareStatement(query);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        String email = rs.getString("email");
                        String role = rs.getString("role");
            %>
                        <option value="<%= email %>"><%= email %> (Current Role: <%= role %>)</option>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                }
            %>
        </select>
        <br><br>
        <label for="newRole">Select New Role:</label>
        <select id="newRole" name="newRole" required>
            <option value="" disabled selected>Select a new role</option>
            <option value="admin">Admin</option>
            <option value="user">User</option>
            <option value="guest">Guest</option>
        </select>
        <br><br>
        <button type="submit">Update Privileges</button>
    </form>
</body>
</html>
