<template>

    <v-card outlined>
        <v-card-title>
            Diary # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DiaryId" v-model="item.diaryId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="Date" v-model="item.date" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserIdx" v-model="item.userIdx" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ImageUrl" v-model="item.imageUrl" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Comment" v-model="item.comment" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DiaryStatus" v-model="item.diaryStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DiaryViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/diaries/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

