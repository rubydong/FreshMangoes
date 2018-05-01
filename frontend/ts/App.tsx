import * as React from "react";
import { Header } from './components/Header';
import { LoginComponent } from './components/LoginComponent';
import { RegisterComponent } from './components/RegisterComponent';
import { Footer } from "./components/Footer";
import Main from './Main';

const App = () => (
  <div>
    <Header />
    <LoginComponent />
    <RegisterComponent/>
    <Main />
    <Footer/>
  </div>
)

export default App
