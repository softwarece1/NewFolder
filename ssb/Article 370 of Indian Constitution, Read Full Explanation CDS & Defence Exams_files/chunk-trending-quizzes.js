(window.webpackJsonp_N_E=window.webpackJsonp_N_E||[]).push([[168],{Jk8t:function(e,t,i){"use strict";i.r(t);i("TeQF"),i("2B1R"),i("+2oP");var n=i("q1tI"),a=i.n(n),l=i("ttZb"),s=i("uCVR"),d=i.n(s),r=i("y+xF"),o=i("Sd6l"),c=i("YFqc"),u=i.n(c),m=i("GQew"),f=i("YiJ4"),v=a.a.createElement,p=function(e){var t=e.id,i=void 0===t?"":t,n=e.examSlug,a=e.examName,s=(Object(l.e)(d.a,{variables:{examId:i},fetchPolicy:"cache-and-network",skip:!i,ssr:!1}).data||{}).trendingQuiz,c=void 0===s?[]:s;if(0===(null==c?void 0:c.length))return null;var p=Object(o.u)(),g=c.filter((function(e){var t,i;return!(null==e||null===(t=e.userActions)||void 0===t||null===(i=t.quizAttempt)||void 0===i?void 0:i.done)})).slice(0,6);return 0===(null==g?void 0:g.length)?null:v("div",{className:"pv1 mb3 ".concat(p?"bg-white ph3":"bg-near-white")},v("a",{className:"link",href:"/practice/quiz/".concat(n)},v("h3",{className:"mb2 ma2 pt2 f4-5 tc-l hover-green"},"".concat(a," Quiz"))),v("ul",{className:"flex flex-column-l flex-row green list ".concat(p?"overflow-auto pl2":"pa0 ma0")},g.map((function(e){var t;return p?v("div",{key:e.id,className:"br2 flex flex-shrink-0 mr3 pa3 b--very-light-gray ba w4-2 w-25-l flex-column items-center"},v(r.a,{key:e.id,showAttempCount:!0,data:e})):v("li",{key:e.id,className:"bt pa3 mb0 b--black-05"},v(u.a,Object(o.D)("/".concat(e.quizSlug)),v("a",{className:"no-underline black f6 flex",title:e.title},v("span",{className:"bg-white pa2 br5 h2"},v(m.a,{spriteIcon:f.a,viewBox:"0 0 47 46",width:"30",height:"30",avoidDefault:!1})),v("span",{className:"flex ml2 flex-column"},v("span",{className:"f6 "},e.title),v("span",{className:"f7 gray"},null==e||null===(t=e.stats)||void 0===t?void 0:t.attempts," Attempts")))))}))))};p.defaultProps={id:"",examSlug:"",examName:""},t.default=p},YiJ4:function(e,t,i){"use strict";var n=i("q1tI"),a=i.n(n).a.createElement;t.a=a("g",{fill:"none",transform:"translate(4.95 3.585)"},a("path",{stroke:"var(--dull-green)",strokeWidth:"1.89",d:"M5.978 30.431l1.735 1.564 1.897 1.651-4.879 4.847a1.83 1.83 0 0 1-2.49.083l-.73-.635a1.83 1.83 0 0 1-.13-2.637l4.597-4.873zM31.12 30.335l-1.452 1.66-1.897 1.651 4.879 4.847a1.83 1.83 0 0 0 2.49.083l.707-.616a1.83 1.83 0 0 0 .11-2.657l-4.837-4.968zM23.48 5.083c1.641-3.37 4.037-4.868 7.188-4.496.037.111 6.56.36 6.56 7.527.005.009-.04 3.45-3.891 6.005M13.878 5.083C12.238 1.713 9.841.215 6.69.587 6.653.698.13.947.13 8.114c-.005.009.04 3.45 3.891 6.005"}),a("path",{fill:"#50B167",d:"M17.374 23.881l5.464-3.536a.457.457 0 0 0 .013-.76l-5.464-3.806a.457.457 0 0 0-.72.375v7.343a.457.457 0 0 0 .707.384z"}),a("circle",{cx:"18.639",cy:"19.808",r:"16.136",stroke:"var(--dull-green)",strokeWidth:"1.89"}))},uCVR:function(e,t){var i={kind:"Document",definitions:[{kind:"OperationDefinition",operation:"query",name:{kind:"Name",value:"trendingQuiz"},variableDefinitions:[{kind:"VariableDefinition",variable:{kind:"Variable",name:{kind:"Name",value:"examId"}},type:{kind:"NonNullType",type:{kind:"NamedType",name:{kind:"Name",value:"ID"}}},directives:[]}],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"trendingQuiz"},arguments:[{kind:"Argument",name:{kind:"Name",value:"examId"},value:{kind:"Variable",name:{kind:"Name",value:"examId"}}}],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"id"},arguments:[],directives:[]},{kind:"Field",name:{kind:"Name",value:"title"},arguments:[],directives:[]},{kind:"Field",alias:{kind:"Name",value:"quizSlug"},name:{kind:"Name",value:"slug"},arguments:[],directives:[]},{kind:"Field",name:{kind:"Name",value:"test"},arguments:[],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"id"},arguments:[],directives:[]},{kind:"Field",name:{kind:"Name",value:"questionCount"},arguments:[],directives:[]},{kind:"Field",name:{kind:"Name",value:"timeLimit"},arguments:[],directives:[]}]}},{kind:"Field",name:{kind:"Name",value:"stats"},arguments:[],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"attempts"},arguments:[],directives:[]}]}},{kind:"Field",name:{kind:"Name",value:"userActions"},arguments:[],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"quizAttempt"},arguments:[],directives:[],selectionSet:{kind:"SelectionSet",selections:[{kind:"Field",name:{kind:"Name",value:"id"},arguments:[],directives:[]},{kind:"Field",name:{kind:"Name",value:"done"},arguments:[],directives:[]}]}}]}}]}}]}}],loc:{start:0,end:236}};i.loc.source={body:"query trendingQuiz ($examId: ID!) {\n\ttrendingQuiz(examId: $examId) {\n\t\tid\n\t\ttitle\n\t\tquizSlug: slug\n\t\ttest {\n\t\t\tid\n\t\t\tquestionCount\n\t\t\ttimeLimit\n\t\t}\n\t\tstats {\n\t\t\tattempts\n\t\t}\n\t\tuserActions {\n\t\t\tquizAttempt {\n\t\t\t\tid\n\t\t\t\tdone\n\t\t\t}\n\t\t}\n\t}\n}",name:"GraphQL request",locationOffset:{line:1,column:1}};var n={};function a(e,t){for(var i=0;i<e.definitions.length;i++){var n=e.definitions[i];if(n.name&&n.name.value==t)return n}}i.definitions.forEach((function(e){if(e.name){var t=new Set;!function e(t,i){if("FragmentSpread"===t.kind)i.add(t.name.value);else if("VariableDefinition"===t.kind){var n=t.type;"NamedType"===n.kind&&i.add(n.name.value)}t.selectionSet&&t.selectionSet.selections.forEach((function(t){e(t,i)})),t.variableDefinitions&&t.variableDefinitions.forEach((function(t){e(t,i)})),t.definitions&&t.definitions.forEach((function(t){e(t,i)}))}(e,t),n[e.name.value]=t}})),e.exports=i,e.exports.trendingQuiz=function(e,t){var i={kind:e.kind,definitions:[a(e,t)]};e.hasOwnProperty("loc")&&(i.loc=e.loc);var l=n[t]||new Set,s=new Set,d=new Set;for(l.forEach((function(e){d.add(e)}));d.size>0;){var r=d;d=new Set,r.forEach((function(e){s.has(e)||(s.add(e),(n[e]||new Set).forEach((function(e){d.add(e)})))}))}return s.forEach((function(t){var n=a(e,t);n&&i.definitions.push(n)})),i}(i,"trendingQuiz")},"y+xF":function(e,t,i){"use strict";var n=i("wx14"),a=i("q1tI"),l=i.n(a),s=i("YFqc"),d=i.n(s),r=i("Sd6l"),o=i("GQew"),c=i("YiJ4"),u=l.a.createElement,m=function(e){var t=e.data,i=e.showAttempCount,a=t.title,l=t.quizSlug,s=t.isTrending,m=void 0!==s&&s,f=t.test,v=f.questionCount,p=f.timeLimit,g=t.stats,k=(g=void 0===g?{}:g).attempts;return u("section",{className:"flex flex-column items-center pointer"},m?u("img",{className:"lazyload flex-shrink-0 w2 h2-5","data-src":Object(r.l)("https://gs-post-images.grdp.co/2019/11/popular-quizzes-m-2x-img1572937940006-14.png-rs-high-webp.png",["width=128","height=128","quality=75"]),src:Object(r.l)("https://gs-post-images.grdp.co/2019/11/popular-quizzes-m-2x-img1572937940006-14.png-rs-high-webp.png",["width=128","height=128","quality=75"]),alt:"Trending quiz"}):u(o.a,{classes:"db svg-s-green svg-fg flex-shrink-0 h2-5",spriteIcon:c.a,viewBox:"0 0 47 46",width:"40",height:"50",style:{strokeWidth:"1px"},avoidDefault:!1}),u("p",{className:"h2-5 double-line-ellipsis f6 fw6 mv2 tc"}," ",a," "),i&&k?u("ul",{className:"pl3 overflow-hidden w-100 f7"},u("li",{className:"gray fw2"},"Attempts ",u("span",{className:"fr ml-auto fw7"}," ",k," ")),u("li",{className:"gray fw2"},"Questions ",u("span",{className:"fr ml-auto fw7"}," ",v," ")),u("li",{className:"gray fw2 mb0"},"Time"," ",u("span",{className:"fr ml-auto fw7"},p," ",p>1?" mins ":" min "))):u("span",{className:"f7 gray"},v," Ques / ",p," Mins"),u(d.a,Object(n.a)({passHref:!0},Object(r.D)("/".concat(l))),u("a",{className:"".concat(m?"bg-red":"bg-green"," bn white br2 mt3 pv2 outline-0 f6-5 w4 pointer tc link no-hover-color")},"START QUIZ")))};m.defaultProps={showAttempCount:!1},t.a=m}}]);
//# sourceMappingURL=chunk-trending-quizzes.97158fc9ec3d0da4af1e.js.map