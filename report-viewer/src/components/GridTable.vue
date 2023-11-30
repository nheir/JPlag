<!--
  Table which contains all of the matches for a comparison with navigation links.
-->
<template>
    <div class="grid-table-container">
        <svg width="100%" :viewBox="'0 0 ' + ids.length * 10 + ' ' + ids.length * 10">
            <g v-for="(id1, i1) in ids" :key="id1">
                <rect v-for="(id2, i2) in ids" :key="id2" :x="i2 * 10" :y="i1 * 10" width="10" height="10"
                    :fill="simToColor(comps[id1][id2])" :title="id1" @click="
                        navigateToComparisonView(
                            id1,
                            id2
                        )">
                        <title>{{ id1 }} {{ id2 }}</title>
                        </rect>
            </g>
        </svg>
    </div>
</template>
  
<script lang="ts">
import { defineComponent } from "vue";
import { Overview } from "@/model/Overview";
import { ComparisonListElement } from "@/model/ComparisonListElement";
import { useStore } from "vuex";
import router from "@/router";

export default defineComponent({
    name: "GridTable",
    props: {
        /**
         * Overview
         */
        overview: {
            type: Overview,
            required: true,
        },
        topComps: {
            type: Array<ComparisonListElement>,
            required: true,
        }
    },
    setup(props) {
        const store = useStore();
        let comps: { [id1: string]: { [id2: string]: number } } = {};
        for (const comp of props.topComps) {
            if (!(comp.firstSubmissionId in comps)) comps[comp.firstSubmissionId] = {};
            if (!(comp.secondSubmissionId in comps)) comps[comp.secondSubmissionId] = {};
            comps[comp.firstSubmissionId][comp.secondSubmissionId] = comp.similarity;
            comps[comp.secondSubmissionId][comp.firstSubmissionId] = comp.similarity;
        }
        let ids = new Array<string>();
        for (const cluster of props.overview.clusters) {
            for (const id of cluster.members) {
                if (!ids.includes(id))
                    ids.push(id);
            }
        }
        for (const id of Object.keys(comps))
            if (!ids.includes(id))
                ids.push(id);

        const navigateToComparisonView = (firstId: string, secondId: string) => {
            if (!store.state.single) {
                router.push({
                    name: "ComparisonView",
                    params: { firstId, secondId },
                });
            }
        };

        const simToColor = (sim: number) => {
            if (sim == undefined) return 'black';
            return `hsl(${120 - sim * 180} 90% 50%)`;
        };

        // ids.sort();
        return {
            comps,
            ids,
            navigateToComparisonView,
            simToColor,
        }
    }
});
</script>
  
<style scoped>
.grid-table-container {
    width: 100%;
    margin-top: 2%;
    padding: 1%;
    background: var(--primary-color-dark);
    border-radius: 10px;
    overflow: auto;
}
</style>
  