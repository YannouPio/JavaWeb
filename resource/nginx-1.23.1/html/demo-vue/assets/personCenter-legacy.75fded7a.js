System.register(["./require-legacy.04066320.js","./index-legacy.05c79910.js"],(function(e,t){"use strict";var n,s,r,a=document.createElement("style");return a.textContent="",document.head.appendChild(a),{setters:[function(e){n=e.r,s=e.a},function(e){r=e.n}],execute:function(){e("default",r({name:"PersonCenter",data:function(){return{username:"",personInfo:{}}},created:function(){this.username=this.$route.query.username,this.getPerson()},methods:{getPerson:function(){var e,t=this;(e=this.username,n({url:"/8/person-center",method:"get",params:{username:e}})).then((function(e){t.personInfo=e}))},clearToken:function(){s(),this.getPerson()}}},(function(){var e=this,t=e._self._c;return t("div",{staticClass:"app-container"},[t("el-card",{staticClass:"box-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[e._v("JWT信息")]),t("el-button",{staticStyle:{float:"right"},attrs:{type:"danger"},on:{click:e.clearToken}},[e._v("清除token")])],1),t("div",{staticClass:"text item"},[t("el-descriptions",{staticClass:"margin-top",attrs:{direction:"vertical",column:3,border:""}},[t("el-descriptions-item",{attrs:{label:"Header"}},[e._v(e._s(e.personInfo.header))]),t("el-descriptions-item",{attrs:{label:"Payload"}},[e._v(e._s(e.personInfo.payload))]),t("el-descriptions-item",{attrs:{label:"Signature"}},[e._v(e._s(e.personInfo.signature))])],1)],1)])],1)}),[],!1,null,"b1fbcdd2",null,null).exports)}}}));