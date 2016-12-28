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
            //获取所有选中的节点


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

$(document).ready(function(){
    $.get("/menu/getMenuTree",function(result){
        setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
        $.fn.zTree.init($("#treeDemo"), setting, result.data);
    });
});


