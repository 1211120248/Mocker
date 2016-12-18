$(function(){
    var userService = {
        dg:$("#dg"),
        init:function(){
            //初始化用户表格
            this.initUserDataGrid();
        },
        initUserDataGrid:function(){
            this.dg.datagrid({
                method:"get",
                rownumbers:true,
                singleSelect:true,
                autoRowHeight:false,
                pagination:true,
                fitColumns:true,
                striped:true,
                checkOnSelect:false,
                selectOnCheck:false,
                collapsible:true,
                toolbar:"#tb",
                pageSize:10,
                columns:[[
                    {field:'username',title:'用户名',width:100,align:"center"},
                    {field:'loginName',title:'账户',width:100,align:"center"},
                    {field:'state',title:'状态',width:100,align:"center"}
                ]]
            });
            var self = this;
            $.getJSON("/user", function(r){
                self.dg.datagrid("loadData",r.data.data)
            });
        }
    };

    userService.init();
});
