<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">User Management</h2>
        <div class="d-flex justify-content-between mb-3">
            <a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-primary">Add New User</a>
        </div>
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Admin</th>
                    <th>Active</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${listUser}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.fullname}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td><c:choose>
                            <c:when test="${user.admin}">Yes</c:when>
                            <c:otherwise>No</c:otherwise>
                        </c:choose></td>
                        <td><c:choose>
                            <c:when test="${user.active}">Yes</c:when>
                            <c:otherwise>No</c:otherwise>
                        </c:choose></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/user/edit?username=${user.username}&page=${currentPage}" class="btn btn-sm btn-warning">Edit</a>
                            <a href="${pageContext.request.contextPath}/admin/user/delete?id=${user.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-between">
            <c:choose>
                <c:when test="${currentPage > 0}">
                    <a href="${pageContext.request.contextPath}/admin/users?page=${currentPage - 1}" class="btn btn-secondary">Previous</a>
                </c:when>
                <c:otherwise>
                    <span class="btn btn-secondary disabled">Previous</span>
                </c:otherwise>
            </c:choose>

            <span>Page ${currentPage + 1} of ${totalPages}</span>

            <c:choose>
                <c:when test="${currentPage + 1 < totalPages}">
                    <a href="${pageContext.request.contextPath}/admin/users?page=${currentPage + 1}" class="btn btn-secondary">Next</a>
                </c:when>
                <c:otherwise>
                    <span class="btn btn-secondary disabled">Next</span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
