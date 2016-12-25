$(function(){
    $('#tt').treegrid({
        fit:true,
        fitColumns:true,
        url:'/menu',
        method:"get",
        idField:'id',
        treeField:'name',
        columns:[[
            {field:'name',title:'菜单名称',width:"20%"},
            {field:'type',title:'菜单类型',width:"10%"},
            {field:'url',title:'菜单路径',width:"50%"},
            {field:'permission',title:'菜单权限',width:"10%"},
            {field:'sort',title:'菜单顺序',width:"10%"}
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
var tt = $("#tt");
var vm = new Vue({
    el:'#app',
    data:{
        menu:{
            name:"",
            url:"",
            icon:"",
            permission:"",
            type:"",
            parentId:"",
            parentName:""
        }
    },
    methods: {
        openSavePage:function(){
            //先清除页面在打开
            this.clearSavePage();
            //获取parentId
            var seleleMenu = tt.treegrid("getSelected");
            if(seleleMenu != null){
                vm.menu.parentId = seleleMenu.id;
                vm.menu.parentName = seleleMenu.name;
            }
            $("#saveModal").modal('show');
        },
        closeSavePage:function(){
            $("#saveModal").modal('hide');
        },
        clearSavePage:function(){
            //清空保存页面中之前的数据
            vm.menu.name="";
            vm.menu.url="";
            vm.menu.icon="";
            vm.menu.permission="";
            vm.menu.type="";
            vm.menu.parentId="";
        },save:function(){
            var data = {
                name:vm.menu.name,
                url:vm.menu.url,
                icon:vm.menu.icon,
                permission:vm.menu.permission,
                type:vm.menu.type,
                parentId:vm.menu.parentId,
                parentName:vm.menu.parentName
            }
            $.ajax({
                type: "POST",
                url: "/menu",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(data),
                dataType: "json",
                success: function(result){
                    tt.treegrid("reload");
                }
            });
        },

    }
});



