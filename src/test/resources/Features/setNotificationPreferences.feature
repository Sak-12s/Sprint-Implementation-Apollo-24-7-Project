Feature: Verification of enabling notifications

Scenario: Verifictaion of enabling push notifications works successfully
Given the user clicks on the Notification Preferences
When the user enables the Push Notification
Then the push notification is enabled

Scenario: Verification of enabling SMS notifications works successfully
Given the user clicks on the Notification Preferences
When the user enables the SMS Notification
Then the sms notification is enabled