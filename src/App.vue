<template>
  <nav>
    <Header/>
  </nav>
  <router-view/>
</template>

<style>

</style>

<script>
    import Header from "@/components/Header";

    export default {
        name:"Layout",
        components:{
            Header
        }
    }
</script>