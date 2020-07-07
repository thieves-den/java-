<template>
  <el-table :data="data_list">
     <el-table-column  :label="date" v-for="(date, key) in header">
             <template scope="scope">
                   {{data_list[scope.$index][key]}}
              </template>
       </el-table-column>
    </el-table>
  </template>
 <script>
      export default {
      data() {
            return {
                header:["column1","column2", "column3"],
                data_list:[
                    [1, 2, 3],
                    [4,5,6]
                ]
            }
        }
    }
 </script>