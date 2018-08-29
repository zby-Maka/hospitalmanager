$(function () {
    var LODOP;
});

function printview() {
    alert("123")
    createPage();
    LODOP.PREVIEW(); //打印预览
}

function updatePrint() {
    createPage();
    LODOP.PRINT_SETUP();//打印维护
}

function print() {
    createPage();
    LODOP.PRINT_DESIGN();//直接打印
}

function createPage() {

    LODOP = getLodop();  //获取打印对象
    var style = "<style>" + document.getElementById("style").innerHTML + "</style>";
    var html = style + "<body>" + document.getElementById("dy").innerHTML + "</body>";
    LODOP.SET_PRINT_STYLE("Bold", 1); //字体加粗
    LODOP.ADD_PRINT_HTM(20,50,640,890,html); //打印HTML

}


//LODOP.ADD_PRINT_TEXT(50,50,50,50,"已打印"); //打印文字