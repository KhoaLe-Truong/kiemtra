<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/user/update" method="post">
    <!-- Username (hidden, as it acts as a unique identifier) -->
    <input type="text" id="username" name="username" value="${user.username}" hidden="hidden"><br>

    <!-- Full Name -->
    <label for="fullname">Full Name:</label><br>
    <input type="text" id="fullname" name="fullname" value="${user.fullname}"><br>

    <!-- Email -->
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" value="${user.email}"><br>

    <!-- Phone -->
    <label for="phone">Phone:</label><br>
    <input type="text" id="phone" name="phone" value="${user.phone}"><br>

    <!-- Password -->
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" value="${user.password}"><br>

    <!-- Admin Checkbox -->
    <label for="admin">Admin:</label><br>
    <input type="checkbox" id="admin" name="admin" ${user.admin ? 'checked' : ''}><br>

    <!-- Active Checkbox -->
    <label for="active">Active:</label><br>
    <input type="checkbox" id="active" name="active" ${user.active ? 'checked' : ''}><br>

    <!-- Image URL -->
    <label for="images">Profile Image URL:</label><br>
    <input type="text" id="images" name="images" value="${user.images}"><br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>

</body>
</html>
