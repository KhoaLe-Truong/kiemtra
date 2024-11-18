<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Add New User</h2>
        <form action="${pageContext.request.contextPath}/admin/user/insert" method="post" class="mt-4">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="fullname" class="form-label">Full Name</label>
                <input type="text" id="fullname" name="fullname" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" id="phone" name="phone" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="admin" class="form-label">Admin</label>
                <select id="admin" name="admin" class="form-select">
                    <option value="true">Yes</option>
                    <option value="false" selected>No</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="active" class="form-label">Active</label>
                <select id="active" name="active" class="form-select">
                    <option value="true" selected>Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add User</button>
            <a href="${pageContext.request.contextPath}/admin/users" class="btn btn-secondary">Back</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
