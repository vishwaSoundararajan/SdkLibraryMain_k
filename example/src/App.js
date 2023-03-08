import React, {useEffect} from 'react';
import {Text,TouchableOpacity,View, StyleSheet} from 'react-native';
import {requestUserPermission, NotificationServices} from './PushNotifications.js';
import Librarysdk from './CustomModule.js';
import messaging from '@react-native-firebase/messaging';
const App = () => {
    messaging().setBackgroundMessageHandler(async remoteMessage => {
      console.log('Message handled in the background!', remoteMessage);
      Librarysdk.isReNotification(remoteMessage.getData());
    });
   function m1(){
        let jsonData = {
               "uid": "1",
                "adid": "8",
                "useruid": "7",
               "name": "karthik1",
               "age": "22",
               "email": "karthikrathinavel@email.com",
               "phone": "1234567890",
               "gender": "M",
               "profileURL": "https://github.com/karthikrathinavel",
               "dob": "26/01/2001",
               "education": "B.E",
               "employed": false,
               "married": false,
               "token": "em3EVov-Rzy3wkLqnmGipd:APA91bGQZzMMqY1u2HOdLBe3owHUSDkG52n55T6J6Tj-DwJeUpCX4Hks25NzL18tQ2kyMxZOtXLCBy7U5aaOMQsaf8cCnNgw9b9L4mBzXzXNtOB75rp6Mz8tK6Ag66GRlZoFtKRwNznk"
             }
             let jsonString = JSON.stringify(jsonData);
             Librarysdk.onDeviceUserRegister(jsonString);
   }
//  CustomModule.show();
  function locationUpdate(){
       var location = {
        latitude: 13.067439,
        longitude: 80.237617
       }
       Librarysdk.location(location.latitude, location.longitude);
     }
   function conversion(){
       Librarysdk.appConversionTracking();
     }
     function conversion1(){
      var data = '{"name":"John", "age":30, "city":"New York"}';
      Librarysdk.appConversionTracking1(data);
     }
   function addNewNotification(){
       var notificationTitle = "Sample Title";
       var notificationBody = "Sample Body";
       Librarysdk.addNewNotification(notificationTitle, notificationBody);
     }
     function delNotificationById(){
       var id = "1673501625026";
       Librarysdk.deleteNotificationByNID(id);
     }
     function delNotificationByObj(){
       var jsonData = {
        "campaignId": "1675935347197",
        "object": "notification"
       }
       let jsonString = JSON.stringify(jsonData);
       Librarysdk.deleteNotificationByObject(jsonString);
     }
     function getReadNotificationCount(){
       Librarysdk.getReadNotificationCount();
     }
     function updatePushToken(){
       Librarysdk.updatePushToken();
     }
     function onTrackEvent(){
       Librarysdk.onTrackEvent();
     }
     function readNotification(){
          Librarysdk.readNotification();
        }
        function unReadNotification(){
          Librarysdk.unReadNotification();
        }
        function getDeepLinkData(){
          Librarysdk.getDeepLinkData();
        }
        function formDataCapture(){
          let jsonData = {
              "formid": 123,
              "apikey":"b78db6b3-9462-4132-a4d3-894db10b3782",
              "name": "John",
              "age": 30,
              "city": "New York"
          };
          let jsonString = JSON.stringify(jsonData);
          Librarysdk.formDataCapture(jsonString);
        }
        function onReceivedCampaign(){
          Librarysdk.onReceivedCampaign();
        }
        function getUnreadNotificationCount(){
          Librarysdk.getUnreadNotificationCount();
        }
        function getNotifications(){
          Librarysdk.getNotifications();
        }
        function emitEvent(){
          Librarysdk.emitEvent();
        }
  useEffect(()=>{
    requestUserPermission();
    NotificationServices();
  },[]);
  return(
    <View>
      <TouchableOpacity onPress={m1} style = {styles.countContainer}><Text>onDeviceUserRegister</Text></TouchableOpacity>
      <TouchableOpacity onPress={locationUpdate} style={styles.countContainer}>
           <Text style={{color: '#fff'}}>locationUpdate</Text>
         </TouchableOpacity>
         <TouchableOpacity onPress={conversion} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>appConversionTracking</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={conversion1} style={styles.countContainer}>
              <Text style={{color: '#fff'}}>appConversionTrackingWithData</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={addNewNotification} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>addNewNotification</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={delNotificationById} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>DelNotificationbyid</Text>
               </TouchableOpacity>
             {/*<TouchableOpacity onPress={delNotificationByObj} style={styles.countContainer}>
              <Text style={{color: '#fff'}}>DelNotificationbyObject</Text>
             </TouchableOpacity>*/}
             <TouchableOpacity onPress={getReadNotificationCount} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>getReadNotificationCount</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={updatePushToken} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>updatePushToken</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={onTrackEvent} style={styles.countContainer}>
               <Text style={{color: '#fff'}}>onTrackEvent</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={readNotification} style={styles.countContainer}>
                      <Text style={{color: '#fff'}}>readNotification</Text>
                    </TouchableOpacity>
                    <TouchableOpacity onPress={unReadNotification} style={styles.countContainer}>
                      <Text style={{color: '#fff'}}>unReadNotification</Text>
                    </TouchableOpacity>
                    {/*<TouchableOpacity onPress={getDeepLinkData} style={styles.countContainer}>
                      <Text style={{color: '#fff'}}>getDeepLinkData</Text>
                    </TouchableOpacity>*/}
                    <TouchableOpacity onPress={formDataCapture} style={styles.countContainer}>
                      <Text style={{color: '#fff'}}>formDataCapture</Text>
                    </TouchableOpacity>
             {/*<TouchableOpacity onPress={onReceivedCampaign} style={styles.countContainer}>
                                   <Text style={{color: '#fff'}}>onReceivedCampaign</Text>
                                 </TouchableOpacity>*/}
             <TouchableOpacity onPress={getUnreadNotificationCount} style={styles.countContainer}>
              <Text style={{color: '#fff'}}>getUnreadNotificationCount</Text>
             </TouchableOpacity>
             <TouchableOpacity onPress={getNotifications} style={styles.countContainer}>
              <Text style={{color: '#fff'}}>getNotifications</Text>
             </TouchableOpacity>
    </View>
  );
}
const styles = StyleSheet.create({
 countContainer: {
   alignItems: "center",
   padding: 10,
   margin: 5,
   backgroundColor: 'rgba(0,0,0,0.2)',
 }
});
export default App;
