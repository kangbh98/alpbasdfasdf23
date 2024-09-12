<template>

    <v-data-table
        :headers="headers"
        :items="plan"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PlanView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "planIdx", value: "planIdx" },
                { text: "userIdx", value: "userIdx" },
                { text: "placeName", value: "placeName" },
                { text: "address", value: "address" },
                { text: "phone", value: "phone" },
                { text: "date", value: "date" },
                { text: "time", value: "time" },
                { text: "planStatus", value: "planStatus" },
            ],
            plan : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/plans'))

            temp.data._embedded.plans.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.plan = temp.data._embedded.plans;
        },
        methods: {
        }
    }
</script>

