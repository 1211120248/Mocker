$(function(){
    $('#roleTree').treegrid({
        fit:true,
        fitColumns:true,
        url:'/role',
        method:"get",
        idField:'id',
        treeField:'name',
        columns:[[
            {field:'name',title:'角色名称',width:"50%"},
            {field:'note',title:'角色备注',width:"50%"}
        ]],
        loadFilter:function(result){
            var data = result.data;
            if (data){
                data.total = data.totalCount;
                return data;
            }
        }
    });

    $('#menuTree').treegrid({
        fit:true,
        fitColumns:true,
        url:'/menu',
        method:"get",
        idField:'id',
        lines: true,
        treeField:'name',
        columns:[[
            {field:'name',title:'菜单名称',width:"100%"}
        ]],
        loadFilter:function(result){
            var data = result.data;
            if (data){
                data.total = data.totalCount;
                return data;
            }
        }
    });
});

var vm = new Vue({
    el:'#app',
    data:{
        role:{
            name:"",
            note:""
        }
    },
    methods: {
        assginPermission:function(){
            //分配权限
        },
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

