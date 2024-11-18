<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết video</title>
</head>
<body>
    <h1>Chi tiết video</h1>

    <c:if test="${not empty video}">
        <div>
            <img src="${video.poster}" alt="${video.title}" style="width: 300px; height: 200px;">
            <h2>Tiêu đề: ${video.title}</h2>
            <p><strong>Mã video:</strong> ${video.id}</p>
            <p><strong>Thể loại:</strong> ${video.categoryName}</p>
            <p><strong>Lượt xem:</strong> ${video.views}</p>
            <p><strong>Chia sẻ:</strong> ${video.shares}</p>
            <p><strong>Lượt thích:</strong> ${video.likes}</p>
            <p><strong>Mô tả:</strong> ${video.description}</p>
        </div>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
</body>
</html>
