import {configureStore} from '@reduxjs/toolkit';
import customerPageSlice from './customerPageSlice';

const store=configureStore(
    {
        reducer:{customertable:customerPageSlice.reducer}
    }
)

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch =typeof store.dispatch
export default store;