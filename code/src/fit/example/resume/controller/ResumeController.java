package fit.example.resume.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/resume")
public class ResumeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>个人简历</title>\n" +
                "    <!-- 引入样式 -->\n" +
                "    <link rel=\"stylesheet\" href=\"../corejs/elementui.css\">\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"resume\" class=\"grid-content\">\n" +
                "    <div style=\"font-size: xx-large; font-weight: bold; display: flex; flex-direction: column; align-items: center; margin-top: 20px\">\n" +
                "        求职简历\n" +
                "    </div>\n" +
                "    <hr style=\"width: 67%; margin-top: 15px; margin-bottom: 25px\">\n" +
                "    <el-row :gutter=\"12\">\n" +
                "        <el-col :span=\"4\">&nbsp;</el-col>\n" +
                "        <el-col :span=\"4\">\n" +
                "            <div style=\"display: flex; flex-direction: column; align-items: center; margin-bottom: 25px\">\n" +
                "                <el-image style=\"width: 120px; height: 160px\" :src=\"imageUrl\">\n" +
                "                </el-image>\n" +
                "            </div>\n" +
                "            <el-descriptions column=\"1\" size=\"medium\" border style=\"font-size: large\">\n" +
                "                <el-descriptions-item v-for=\"(item, index) in userInfo\" :key=\"index\">\n" +
                "                    <template slot=\"label\">\n" +
                "                        {{item.key}}\n" +
                "                    </template>\n" +
                "                    {{item.value}}\n" +
                "                </el-descriptions-item>\n" +
                "            </el-descriptions>\n" +
                "        </el-col>\n" +
                "        <el-col :span=\"6\">\n" +
                "            <el-timeline>\n" +
                "                <el-timeline-item size=\"large\" color=\"#409EFF\">\n" +
                "                    <h2>教育经历</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in education\" :key=\"index\">\n" +
                "                            {{item.title}} {{item.dateInterval}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "                <el-timeline-item size=\"large\" color=\"#67C23A\">\n" +
                "                    <h2>实习经历</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in practice\" :key=\"index\">\n" +
                "                            {{item.title}} {{item.dateInterval}} {{item.content}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "                <el-timeline-item size=\"large\" color=\"#E6A23C\">\n" +
                "                    <h2>项目经验</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in project\" :key=\"index\">\n" +
                "                            {{item.title}} {{item.content}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "            </el-timeline>\n" +
                "        </el-col>\n" +
                "        <el-col :span=\"6\">\n" +
                "            <el-timeline>\n" +
                "                <el-timeline-item size=\"large\" color=\"#F56C6C\">\n" +
                "                    <h2>个人荣誉</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in honor\" :key=\"index\">\n" +
                "                            {{item.title}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "                <el-timeline-item size=\"large\" color=\"#EB09EB\">\n" +
                "                    <h2>掌握技能</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in skill\" :key=\"index\">\n" +
                "                            {{item.title}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "                <el-timeline-item size=\"large\" color=\"#5F01D1\">\n" +
                "                    <h2>兴趣爱好</h2>\n" +
                "                    <el-card>\n" +
                "                        <p style=\"font-size: large;\" v-for=\"(item, index) in hobby\" :key=\"index\">\n" +
                "                            {{item.title}}\n" +
                "                        </p>\n" +
                "                    </el-card>\n" +
                "                </el-timeline-item>\n" +
                "            </el-timeline>\n" +
                "        </el-col>\n" +
                "        <el-col :span=\"4\">&nbsp;</el-col>\n" +
                "    </el-row>\n" +
                "    <hr style=\"width: 67%; margin-top: 15px; margin-bottom: 25px;\">\n" +
                "</div>\n" +
                "<!-- 引入组件库 -->\n" +
                "<script type=\"text/javascript\" src=\"../corejs/vue.min.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"../corejs/elementui.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    new Vue({\n" +
                "        el: '#resume',\n" +
                "        data() {\n" +
                "            return {\n" +
                "                userInfo: [{\n" +
                "                    key: '姓名',\n" +
                "                    value: '张三丰'\n" +
                "                }, {\n" +
                "                    key: '性别',\n" +
                "                    value: '男'\n" +
                "                }, {\n" +
                "                    key: '手机号码',\n" +
                "                    value: '18100000000'\n" +
                "                }, {\n" +
                "                    key: '电子邮箱',\n" +
                "                    value: 'zsf@nbt.edu.cn'\n" +
                "                }, {\n" +
                "                    key: '籍贯',\n" +
                "                    value: '浙江省宁波市'\n" +
                "                }, {\n" +
                "                    key: '年龄',\n" +
                "                    value: '21'\n" +
                "                }, {\n" +
                "                    key: '学历',\n" +
                "                    value: '本科'\n" +
                "                }, {\n" +
                "                    key: '政治面貌',\n" +
                "                    value: '党员'\n" +
                "                }, {\n" +
                "                    key: '民族',\n" +
                "                    value: '汉'\n" +
                "                }, {\n" +
                "                    key: '宗教信仰',\n" +
                "                    value: '无'\n" +
                "                }, {\n" +
                "                    key: '健康状况',\n" +
                "                    value: '良好'\n" +
                "                }, {\n" +
                "                    key: '求职意向',\n" +
                "                    value: 'Java后端开发'\n" +
                "                }],\n" +
                "                imageUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',\n" +
                "                education: [{\n" +
                "                    title: '1.宁波市鄞州区堇山小学',\n" +
                "                    dateInterval: '2008年9月-2014年9月'\n" +
                "                }, {\n" +
                "                    title: '2.宁波市兴宁中学',\n" +
                "                    dateInterval: '2014年9月-2017年9月'\n" +
                "                }, {\n" +
                "                    title: '3.宁波市鄞州中学',\n" +
                "                    dateInterval: '2017年9月-2020年9月'\n" +
                "                }, {\n" +
                "                    title: '4.浙大宁波理工学院',\n" +
                "                    dateInterval: '2020年9月-2024年9月'\n" +
                "                }],\n" +
                "                practice: [{\n" +
                "                    title: '1.拼夕夕(上海)网络科技有限公司',\n" +
                "                    dateInterval: '2013年10月-2013年12月',\n" +
                "                    content: '前端开发'\n" +
                "                }, {\n" +
                "                    title: '2.北京京西世纪贸易有限公司',\n" +
                "                    dateInterval: '2014年03月-2014年05月',\n" +
                "                    content: 'Java后端开发'\n" +
                "                }],\n" +
                "                project: [{\n" +
                "                    title: '1.奉化区信用文旅安信游系统',\n" +
                "                    content: 'Springboot+Ant Design Pro'\n" +
                "                }, {\n" +
                "                    title: '2.宁波师范智慧校园项目',\n" +
                "                    content: '微服务架构'\n" +
                "                }],\n" +
                "                honor: [{\n" +
                "                    title: '1.大一学年二等奖学金'\n" +
                "                }, {\n" +
                "                    title: '2.大二学年一等奖学金'\n" +
                "                }, {\n" +
                "                    title: '3.大三学年省政府奖学金'\n" +
                "                }, {\n" +
                "                    title: '4.蓝桥杯计算机程序大赛浙江赛区二等奖'\n" +
                "                }],\n" +
                "                skill: [{\n" +
                "                    title: '1.熟练掌握Java后端开发和前端开发技术，掌握MySQL和金仓等主流数据库操作与配置'\n" +
                "                }, {\n" +
                "                    title: '2.熟练掌握Ubuntu、Centos等操作系统控制与Nginx服务器的配置与部署'\n" +
                "                }],\n" +
                "                hobby: [{\n" +
                "                    title: '1.爱好游泳、羽毛球、篮球等体育项目'\n" +
                "                }, {\n" +
                "                    title: '2.喜欢音乐、交友'\n" +
                "                }]\n" +
                "            }\n" +
                "        }\n" +
                "    })\n" +
                "</script>\n" +
                "<style>\n" +
                "    .grid-content {\n" +
                "        border-radius: 4px;\n" +
                "        min-height: 36px;\n" +
                "        font-family: 华文中宋;\n" +
                "        font-size: x-large;\n" +
                "    }\n" +
                "</style>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
