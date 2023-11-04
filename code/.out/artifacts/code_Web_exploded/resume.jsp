<%--
  Created by IntelliJ IDEA.
  User: Carl
  Date: 2023/11/3
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人简历</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="./corejs/elementui.css">

</head>
<body>
<div id="resume" class="grid-content">
    <div style="font-size: xx-large; font-weight: bold; display: flex; flex-direction: column; align-items: center; margin-top: 20px">
        求职简历
    </div>
    <hr style="width: 67%; margin-top: 15px; margin-bottom: 25px">
    <el-row :gutter="12">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
            <div style="display: flex; flex-direction: column; align-items: center; margin-bottom: 25px">
                <el-image style="width: 120px; height: 160px" :src="imageUrl">
                </el-image>
            </div>
            <el-descriptions column="1" size="medium" border style="font-size: large">
                <el-descriptions-item v-for="(item, index) in userInfo" :key="index">
                    <template slot="label">
                        {{item.key}}
                    </template>
                    {{item.value}}
                </el-descriptions-item>
            </el-descriptions>
        </el-col>
        <el-col :span="6">
            <el-timeline>
                <el-timeline-item size="large" color="#409EFF">
                    <h2>教育经历</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in education" :key="index">
                            {{item.title}} {{item.dateInterval}}
                        </p>
                    </el-card>
                </el-timeline-item>
                <el-timeline-item size="large" color="#67C23A">
                    <h2>实习经历</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in practice" :key="index">
                            {{item.title}} {{item.dateInterval}} {{item.content}}
                        </p>
                    </el-card>
                </el-timeline-item>
                <el-timeline-item size="large" color="#E6A23C">
                    <h2>项目经验</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in project" :key="index">
                            {{item.title}} {{item.content}}
                        </p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </el-col>
        <el-col :span="6">
            <el-timeline>
                <el-timeline-item size="large" color="#F56C6C">
                    <h2>个人荣誉</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in honor" :key="index">
                            {{item.title}}
                        </p>
                    </el-card>
                </el-timeline-item>
                <el-timeline-item size="large" color="#EB09EB">
                    <h2>掌握技能</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in skill" :key="index">
                            {{item.title}}
                        </p>
                    </el-card>
                </el-timeline-item>
                <el-timeline-item size="large" color="#5F01D1">
                    <h2>兴趣爱好</h2>
                    <el-card>
                        <p style="font-size: large;" v-for="(item, index) in hobby" :key="index">
                            {{item.title}}
                        </p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </el-col>
        <el-col :span="4">&nbsp;</el-col>
    </el-row>
    <hr style="width: 67%; margin-top: 15px; margin-bottom: 25px;">
</div>
<!-- 引入组件库 -->
<script type="text/javascript" src="./corejs/vue.min.js"></script>
<script type="text/javascript" src="./corejs/elementui.js"></script>
<script type="text/javascript">
    new Vue({
        el: '#resume',
        data() {
            return {
                userInfo: [{
                    key: '姓名',
                    value: '张三丰'
                }, {
                    key: '性别',
                    value: '男'
                }, {
                    key: '手机号码',
                    value: '18100000000'
                }, {
                    key: '电子邮箱',
                    value: 'zsf@nbt.edu.cn'
                }, {
                    key: '籍贯',
                    value: '浙江省宁波市'
                }, {
                    key: '年龄',
                    value: '21'
                }, {
                    key: '学历',
                    value: '本科'
                }, {
                    key: '政治面貌',
                    value: '党员'
                }, {
                    key: '民族',
                    value: '汉'
                }, {
                    key: '宗教信仰',
                    value: '无'
                }, {
                    key: '健康状况',
                    value: '良好'
                }, {
                    key: '求职意向',
                    value: 'Java后端开发'
                }],
                imageUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                education: [{
                    title: '1.宁波市鄞州区堇山小学',
                    dateInterval: '2008年9月-2014年9月'
                }, {
                    title: '2.宁波市兴宁中学',
                    dateInterval: '2014年9月-2017年9月'
                }, {
                    title: '3.宁波市鄞州中学',
                    dateInterval: '2017年9月-2020年9月'
                }, {
                    title: '4.浙大宁波理工学院',
                    dateInterval: '2020年9月-2024年9月'
                }],
                practice: [{
                    title: '1.拼夕夕(上海)网络科技有限公司',
                    dateInterval: '2013年10月-2013年12月',
                    content: '前端开发'
                }, {
                    title: '2.北京京西世纪贸易有限公司',
                    dateInterval: '2014年03月-2014年05月',
                    content: 'Java后端开发'
                }],
                project: [{
                    title: '1.奉化区信用文旅安信游系统',
                    content: 'Springboot+Ant Design Pro'
                }, {
                    title: '2.宁波师范智慧校园项目',
                    content: '微服务架构'
                }],
                honor: [{
                    title: '1.大一学年二等奖学金'
                }, {
                    title: '2.大二学年一等奖学金'
                }, {
                    title: '3.大三学年省政府奖学金'
                }, {
                    title: '4.蓝桥杯计算机程序大赛浙江赛区二等奖'
                }],
                skill: [{
                    title: '1.熟练掌握Java后端开发和前端开发技术，掌握MySQL和金仓等主流数据库操作与配置'
                }, {
                    title: '2.熟练掌握Ubuntu、Centos等操作系统控制与Nginx服务器的配置与部署'
                }],
                hobby: [{
                    title: '1.爱好游泳、羽毛球、篮球等体育项目'
                }, {
                    title: '2.喜欢音乐、交友'
                }]
            }
        }
    })
</script>
<style>
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
        font-family: 华文中宋;
        font-size: x-large;
    }
</style>
</body>
</html>