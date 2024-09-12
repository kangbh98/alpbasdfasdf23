<template>

    <v-card outlined>
        <v-card-title>
            Plan # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="PlanIdx" v-model="item.planIdx" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserIdx" v-model="item.userIdx" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PlaceName" v-model="item.placeName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Phone" v-model="item.phone" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Date" v-model="item.date" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Time" v-model="item.time" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PlanStatus" v-model="item.planStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PlanViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/plans/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

