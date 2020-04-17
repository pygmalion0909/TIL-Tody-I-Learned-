# select박스에서 선택한 값 알기




 <select @change="selectCustomer">
                            <option>고객사 전체</option>
                            <option v-for="item in customerList" :key="item.id" :value="item.name">{{ item.name }}</option>
                        </select>



                    e.target.value로 했을 때 option의 value값이 나옴