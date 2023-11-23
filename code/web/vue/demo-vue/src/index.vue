<template>
  <div class="app-container">
    <el-button type="primary" @click="toLogin">登录</el-button>
  </div>
</template>
<script>
export default {
  name: "Index",
  data() {
    return {}
  },
  methods: {
    toLogin() {
      this.$router.push("/login");
    }
  }
}
</script>
<style scoped>

</style>