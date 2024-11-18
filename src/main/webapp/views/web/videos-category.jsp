<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videos by Category</title>
</head>
<body>
    <h1>Videos by Category</h1>

    <!-- Hiển thị danh sách danh mục -->
    <div>
        <h2>Danh mục</h2>
        <ul>
            <c:forEach var="category" items="${categories}">
                <li>
                    <a href="?category_CategoryId=${category.categoryId}">
                        ${category.name} 
                        (<c:out value="${category.totalVideos}" />)
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!-- Hiển thị danh sách video -->
    <div>
        <h2>Danh sách video</h2>

        <c:if test="${not empty noVideosMessage}">
            <p>${noVideosMessage}</p>
        </c:if>

        <c:if test="${not empty videos}">
            <ul>
                <c:forEach var="video" items="${videos}">
                    <li>
                        <img src="${video.poster}" alt="${video.title}" style="width: 100px; height: 100px;">
                        <h3>${video.title}</h3>
                        <p>Lượt xem: ${video.views}</p>
                        <p>Thể loại: ${video.categoryName}</p>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
</body>
</html>
