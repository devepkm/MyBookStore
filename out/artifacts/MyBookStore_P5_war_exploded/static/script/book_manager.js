$(function () {
    $("#goBtn").click(function () {
        var pageNo = $("#pn_input").val();

        // var totalPageNo = ${requestScope.page.totalPageNo};

        //set boundary
        if (pageNo > totalPageNo){
            pageNo = totalPageNo;
        }
        if (pageNo < 1){
            pageNo = 1;
        }

        //location.href can get the current url in the browser
        //writing to location.href can redirect to new url
        location.href = "manager/bookServlet?action=page&pageNo=" + pageNo;

    });
});