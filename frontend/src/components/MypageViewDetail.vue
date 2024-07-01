<template>

    <v-card outlined>
        <v-card-title>
            Mypage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="MemberId" v-model="item.memberId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="BookId" v-model="item.bookId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LoanId" v-model="item.loanId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="LoanDate" v-model="item.loanDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="DueDate" v-model="item.dueDate" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MypageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/mypages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

