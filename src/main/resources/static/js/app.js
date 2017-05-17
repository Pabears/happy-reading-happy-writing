"use strict";

$(function () {
    Vue.component('greetings', {
        props: ['fa'],
        template: '<tr><td>{{fa}}</td></tr>'
    });
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!',
            message2: 'fuck Vue!',
            title: 'fuck!',
            fa: false,
            list: []
        },
        created: function () {
            console.log('start')
        },
        methods: {
            func1: function () {
                if (this.fa === true) {
                    this.fa = false;
                } else {
                    this.fa = true;
                }

                console.log('fa');
            },
            func2: function () {
                var request = app.fa;
                $.ajax({
                    url: "/hello/",
                    data: {
                        'title': request
                    },
                    success: function (result) {
                        app.title = result;
                    }
                });
            }
        }
    });
    var stompClient = null;

    function setConnected(connected) {
        $("#connect").prop("disabled", connected);
        $("#disconnect").prop("disabled", !connected);
        if (connected) {
            $("#conversation").show();
        }
        else {
            $("#conversation").hide();
        }
        $("#greetings").html("");
    }

    function connect() {
        var socket = new SockJS('/gs-guide-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function (greeting) {
                console.log(greeting);
                showGreeting(greeting.body);
            });
        });
    }

    function disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        stompClient.send("/app/hello", {},$("#name").val());
    }
    function sendName() {
        stompClient.send("/app/hello", {},$("#name").val());
    }

    function showGreeting(message) {
        app.list.push(message);
    }

    $(function () {
        $( "#connect" ).click(function() { connect(); });
        $( "#disconnect" ).click(function() { disconnect(); });
        $( "#send" ).click(function() { sendName(); });
        $( "#message" ).click(function() { sendName(); });
    });
});
