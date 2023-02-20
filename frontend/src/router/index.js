import { createRouter, createWebHistory } from 'vue-router'
import CalcView from '../views/CalcView.vue'
import Login from '../views/LoginView.vue'
import NotFound from "@/views/NotFound.vue";
import notFound from "@/views/NotFound.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/calc',
      name: 'Calc',
      component: CalcView
    },
    {
      path: '/',
      name: 'login',
      component: Login,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/feedback',
      name: 'Feedback',

      component: () => import('../views/FeedbackView.vue')
    },
    {
      path: '/:catchAll(.*)',
      name: 'NotFound',
      component: notFound

    },
    {
      path: '/404/:resource',
      name: '404Resource',
      component: NotFound,
      props: true
    }

  ]
})

export default router


