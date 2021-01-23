<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<link rel="stylesheet" href="style/pageStyle.css">
</head>
<!-- 导入头部信息 -->
<%@ include file="/header.jsp" %>

</div>
<!--热买商品-->
<div id="hot_goods">
    <h3 class="hot_goods_title">热卖商品</h3>
    <div class="hot_goods_body">
        <ul>
            <li>
                <a href="">
                    <img src="images/goods/goods6.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods7.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods8.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods9.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods10.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods11.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods12.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods13.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods14.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods9.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods10.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods11.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods12.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods13.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods14.png" alt="">
                    <p>小米（MI）小米净化器2智能家用卧室空气净化器除甲醛雾霾P</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>
    <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<!--尾部-->
<%@ include file="/footer.jsp" %>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    })
</script>

</body>



</html>


