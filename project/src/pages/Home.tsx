import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import './Home.css';
import { Plugins } from '@capacitor/core';
import 'matrix-plugin';

const { MatrixPlugin } = Plugins;
var x = [0];

MatrixPlugin.Mult({ a: [1, 2, 3, 4, 5, 6, 7, 8, 9], b: [1, 2, 3, 4, 5, 6, 7, 8, 9] }).then((res: any) => {
  x = res.value;
});
var y = { value: "" };
MatrixPlugin.echo({ value: "YES DUDE" }).then((res: any) => {
  y = res.value;
})
let go = (xx: number[]) => {
  let ret = "";
  for (let i = 0; i < xx.length; i++) {
    ret += xx[i] + " ";
  }

  return ret;

}
const Home: React.FC = () => {

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Blank</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <h1>buy <br />{go(x)}<br /> {y} </h1>
      </IonContent>
    </IonPage>
  );

};

export default Home;
