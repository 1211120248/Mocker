var vm = new Vue({
    el:'#app',
    data:{
        role:{
            name:"",
            note:""
        }
    },
    methods: {
        openSavePage:function(){
            //先清除页面在打开
            this.clearSavePage();
            $("#saveModal").modal('show');
        },
        closeSavePage:function(){
            $("#saveModal").modal('hide');
        },
        clearSavePage:function(){
            //清空保存页面中之前的数据
            vm.role.name="";
            vm.role.note="";
        },save:function(){
            var data = {
                name:vm.role.name,
                note:vm.role.note
            }
            var self = this;
            $.ajax({
                type: "POST",
                url: "/role",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(data),
                dataType: "json",
                success: function(result){
                    self.closeSavePage();
                }
            });
        },

    }
});

var setting = {
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

var code;

function setCheck() {
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
        py = $("#py").attr("checked")? "p":"",
        sy = $("#sy").attr("checked")? "s":"",
        pn = $("#pn").attr("checked")? "p":"",
        sn = $("#sn").attr("checked")? "s":"",
        type = { "Y":py + sy, "N":pn + sn};
    zTree.setting.check.chkboxType = type;
    showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
}
function showCode(str) {
    if (!code) code = $("#code");
    code.empty();
    code.append("<li>"+str+"</li>");
}

$(document).ready(function(){
    $.get("/menu/getMenuTree",function(result){
        $.fn.zTree.init($("#treeDemo"), setting, result.data);
        setCheck();
        $("#py").bind("change", setCheck);
        $("#sy").bind("change", setCheck);
        $("#pn").bind("change", setCheck);
        $("#sn").bind("change", setCheck);
    });
});


