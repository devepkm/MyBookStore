<%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 10/10/2020
  Time: 6:31 PM
  static include nav bar in different pages
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">

    <%--        do not show previous link when it is in first page --%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}">First&nbsp;</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo -1 }">&lt;&nbsp;</a>

    </c:if>


    <%--            display page no--%>
    <c:choose>
        <c:when test="${requestScope.page.totalPageNo <= 5}">
            <c:forEach begin="1" end="${requestScope.page.totalPageNo}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    [${i}]
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>

        <c:when test="${requestScope.page.totalPageNo > 5}">
            <c:choose>

                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo <= requestScope.page.totalPageNo - 2}">
                    <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}"
                               var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo - 4}" end="${requestScope.page.totalPageNo}"
                               var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>

            </c:choose>
        </c:when>


    </c:choose>


    <%--        do not show next link when it is in last page --%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.totalPageNo}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">&gt;&nbsp;</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.totalPageNo}">Last</a>
    </c:if>

    &nbsp;&nbsp;&nbsp;&nbsp; ${requestScope.page.totalPageNo} Pages, ${requestScope.page.totalRecord}
    Records&nbsp;<span>Page&nbsp;<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/> </span>
    <input id="goBtn" type="button" value="Go">
</div>

<script type="text/javascript">
    $(function () {
        $("#goBtn").click(function () {
            var pageNo = $("#pn_input").val();

            var totalPageNo = ${requestScope.page.totalPageNo};

            //set boundary
            if (pageNo > totalPageNo) {
                pageNo = totalPageNo;
            }
            if (pageNo < 1) {
                pageNo = 1;
            }

            //location.href can get the current url in the browser
            //writing to location.href can redirect to new url
            location.href = "${requestScope.page.url}&pageNo=" + pageNo;

        });
    });
</script>