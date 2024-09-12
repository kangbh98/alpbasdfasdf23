<template>

    <v-data-table
        :headers="headers"
        :items="diary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DiaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "diaryId", value: "diaryId" },
                { text: "date", value: "date" },
                { text: "userIdx", value: "userIdx" },
                { text: "imageUrl", value: "imageUrl" },
                { text: "comment", value: "comment" },
                { text: "diaryStatus", value: "diaryStatus" },
            ],
            diary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/diaries'))

            temp.data._embedded.diaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.diary = temp.data._embedded.diaries;
        },
        methods: {
        }
    }
</script>

