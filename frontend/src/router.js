
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BookBookManager from "./components/listers/BookBookCards"
import BookBookDetail from "./components/listers/BookBookDetail"

import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"

import LoanLoanManager from "./components/listers/LoanLoanCards"
import LoanLoanDetail from "./components/listers/LoanLoanDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/books/books',
                name: 'BookBookManager',
                component: BookBookManager
            },
            {
                path: '/books/books/:id',
                name: 'BookBookDetail',
                component: BookBookDetail
            },

            {
                path: '/members/members',
                name: 'MemberMemberManager',
                component: MemberMemberManager
            },
            {
                path: '/members/members/:id',
                name: 'MemberMemberDetail',
                component: MemberMemberDetail
            },

            {
                path: '/loans/loans',
                name: 'LoanLoanManager',
                component: LoanLoanManager
            },
            {
                path: '/loans/loans/:id',
                name: 'LoanLoanDetail',
                component: LoanLoanDetail
            },




    ]
})
